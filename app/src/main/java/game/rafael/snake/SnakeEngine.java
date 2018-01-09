package game.rafael.snake;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.factory.BoardFactory;

class SnakeEngine extends SurfaceView implements Runnable {
    private Thread thread = null;

    private Context context;

    public enum Heading {UP, RIGHT, DOWN, LEFT}
    private Heading heading = Heading.RIGHT;

    private int screenX;
    private int screenY;

    private int blockSize;

    private final int NUM_BLOCKS_WIDE = 40;
    private int numBlocksHigh;

    private long nextFrameTime;
    private final long FPS = 10;
    private final long MILLIS_PER_SECOND = 1000;

    private int snakeXs;
    private int snakeYs;

    private volatile boolean isPlaying;

    private Canvas canvas;
    private Paint paint = new Paint();

    private SurfaceHolder surfaceHolder;
    private GameComponent boardComponent;
    private int nivel;

    public SnakeEngine(Context context, Point size, int nivel) {
        super(context);

        this.context = context;
        this.nivel = nivel;

        screenX = size.x;
        screenY = size.y;
        Resources resources = getResources();

        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            screenY -=  resources.getDimensionPixelSize(resourceId);
        }

        blockSize = screenX / NUM_BLOCKS_WIDE;
        numBlocksHigh = new Double(Math.floor(screenY / blockSize)).intValue() - 4;
        surfaceHolder = getHolder();
        newGame();
    }

    @Override
    public void run() {

        while (isPlaying) {
            if(updateRequired()) {
                update();
                draw();
            }
        }
    }

    public void pause() {
        isPlaying = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }


    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void destroy() {
        thread.interrupt();
    }

    public void newGame() {
        snakeXs = NUM_BLOCKS_WIDE / 2;
        snakeYs = numBlocksHigh / 2;

        switch (nivel) {
            case 2:
                boardComponent = BoardFactory.createNivel2Board(NUM_BLOCKS_WIDE,numBlocksHigh,blockSize,new game.rafael.snake.model.Point(snakeXs, snakeYs));
                break;
            case 3:
                boardComponent = BoardFactory.createNivel3Board(NUM_BLOCKS_WIDE,numBlocksHigh,blockSize,new game.rafael.snake.model.Point(snakeXs, snakeYs));
                break;
            default:
                boardComponent = BoardFactory.createNivel1Board(NUM_BLOCKS_WIDE,numBlocksHigh,blockSize,new game.rafael.snake.model.Point(snakeXs, snakeYs));
        }

        nextFrameTime = System.currentTimeMillis();
    }

    private void moveSnake(){
        switch (heading) {
            case UP:
                snakeYs--;
                break;

            case RIGHT:
                snakeXs++;
                break;

            case DOWN:
                snakeYs++;
                break;

            case LEFT:
                snakeXs--;
                break;
        }
        if (snakeXs >= 0) {
            snakeXs = snakeXs % (NUM_BLOCKS_WIDE + 1);
        } else {
            snakeXs = snakeXs + NUM_BLOCKS_WIDE;
        }
        if (snakeYs >= 0) {
            snakeYs = snakeYs % (numBlocksHigh + 1);
        } else {
            snakeYs = snakeYs + numBlocksHigh;
        }

        boardComponent.setNewPoint(new game.rafael.snake.model.Point(snakeXs, snakeYs));
    }

    private boolean detectDeath(){
        return boardComponent.checkCollide(new game.rafael.snake.model.Point(snakeXs, snakeYs));
    }

    public void update() {
        moveSnake();

        if (detectDeath()) {
            ((SnakeActivity) context).showScoreActivity(nivel, boardComponent.getScore());
        }
    }
    public void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();

            boardComponent.draw(canvas);
            paint.setColor(Color.argb(255, 244, 235, 66));
            paint.setTextSize(90);
            canvas.drawText(context.getString(R.string.score_label) + boardComponent.getScore(), 10, 70, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public boolean updateRequired() {
        if(nextFrameTime <= System.currentTimeMillis()){
            nextFrameTime =System.currentTimeMillis() + MILLIS_PER_SECOND / FPS;
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                if (motionEvent.getX() >= screenX / 2) {
                    switch(heading){
                        case UP:
                            heading = Heading.RIGHT;
                            break;
                        case RIGHT:
                            heading = Heading.DOWN;
                            break;
                        case DOWN:
                            heading = Heading.LEFT;
                            break;
                        case LEFT:
                            heading = Heading.UP;
                            break;
                    }
                } else {
                    switch(heading){
                        case UP:
                            heading = Heading.LEFT;
                            break;
                        case LEFT:
                            heading = Heading.DOWN;
                            break;
                        case DOWN:
                            heading = Heading.RIGHT;
                            break;
                        case RIGHT:
                            heading = Heading.UP;
                            break;
                    }
                }
        }
        return true;
    }
}