package game.rafael.snake.component.board.decorator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.component.board.GameBoard;
import game.rafael.snake.model.Point;


public abstract class BaseDecorator extends GameBoard {

    private GameComponent component;
    protected List<Point> points;
    private Paint paint;

    public BaseDecorator(GameComponent component) {
        super(component.getNumBlocksWide(), component.getNumBlocksHigh(), component.getBlockSize());
        this.component = component;
        this.paint = new Paint();
        paint.setColor(Color.argb(255, 255, 255, 255));

        points = new ArrayList<>();
        this.populatePoints();
    }

    @Override
    public void draw(Canvas canvas) {
        component.draw(canvas);
        for (Point point : points) {
            canvas.drawRect(point.getX() * getBlockSize(),
                    point.getY() * getBlockSize(),
                    (point.getX() + 1) * getBlockSize(),
                    (point.getY() + 1) * getBlockSize(),
                    paint);
        }
    }

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.addAll(this.points);
        points.addAll(component.getPoints());

        return points;
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        component.setNewPoint(position, hasToIncreaseSize);
    }


    @Override
    public void addComponent(GameComponent component) {
        this.component.addComponent(component);
    }

    @Override
    public void removeComponent(GameComponent component) {
        this.component.removeComponent(component);
    }

    @Override
    public Boolean checkCollide(Point point) {
        return this.points.contains(point) || component.checkCollide(point);
    }

    @Override
    public int getScore() {
        return this.component.getScore();
    }

    public abstract void populatePoints();
}