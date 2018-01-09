package game.rafael.snake.component.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;

public class Snake extends GameComponent {
    protected List<Point> positions;
    protected Point head;
    private Paint blackPaint;
    private Paint orangePaint;

    public Snake(Point initialPosition, int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(numBlocksWide, numBlocksHigh, blockSize);

        this.positions = new ArrayList<>();
        head = initialPosition;

        blackPaint = new Paint();
        orangePaint = new Paint();
        orangePaint.setColor(Color.rgb(244, 149, 66));
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < positions.size(); i++) {
            canvas.drawRect(positions.get(i).getX() * getBlockSize(),
                    (positions.get(i).getY() * getBlockSize()),
                    (positions.get(i).getX() * getBlockSize()) + getBlockSize(),
                    (positions.get(i).getY() * getBlockSize()) + getBlockSize(),
                    blackPaint);
        }
        canvas.drawRect(head.getX() * getBlockSize(),
                (head.getY() * getBlockSize()),
                (head.getX() * getBlockSize()) + getBlockSize(),
                (head.getY() * getBlockSize()) + getBlockSize(),
                orangePaint);
    }

    @Override
    public List<Point> getPoints() {
        return positions;
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        if (hasToIncreaseSize) {
            positions.add(head);
        } else {
            if (positions.size() > 0) {
                positions.remove(0);
                positions.add(head);
            }
        }
        head = position;
    }

    @Override
    public Boolean checkCollide(Point point) {
        return false;
    }
}
