package game.rafael.snake.component.fruit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Arrays;
import java.util.List;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;
import game.rafael.snake.strategy.RngStrategy;

public class SimpleFruit extends GameComponent {
    Point position;

    RngStrategy strategy;

    Paint paint;

    public SimpleFruit(RngStrategy strategy, int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(numBlocksWide, numBlocksHigh, blockSize);

        this.position = strategy.gerenatePoint();
        this.strategy = strategy;

        this.paint = new Paint();
        paint.setColor(Color.argb(255, 255, 0, 0));
    }

    @Override
    public void draw(Canvas canvas) {
        if (position == null) {
            return;
        }

        canvas.drawRect(position.getX() * getBlockSize(),
                (position.getY() * getBlockSize()),
                (position.getX() * getBlockSize()) + getBlockSize(),
                (position.getY() * getBlockSize()) + getBlockSize(),
                paint);
    }

    @Override
    public List<Point> getPoints() {
        return Arrays.asList(position);
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        if (position.equals(this.position)) {
            addScore();
            this.position = strategy.gerenatePoint();
        }
    }

    @Override
    public Boolean hasToIncreaseSize(Point position) {
        return position.equals(this.position);
    }

    @Override
    public void addScore() {
        super.addScore(1);
    }

    @Override
    public Boolean checkCollide(Point point) {
        return Boolean.FALSE;
    }
}
