package game.rafael.snake.component.board;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;


public class GameBoard extends GameComponent {

    private List<GameComponent> components;

    public GameBoard(int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(numBlocksWide, numBlocksHigh, blockSize);
        components = new ArrayList<>();
    }

    @Override
    public void draw(final Canvas canvas) {
        canvas.drawColor(Color.argb(255, 26, 128, 182));
        for (GameComponent component : components) {
            component.draw(canvas);
        }
    }

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        for (GameComponent component: components) {
            points.addAll(component.getPoints());
        }

        return points;
    }

    @Override
    public void addComponent(GameComponent component) {
        components.add(component);
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        for (GameComponent component : components) {
            hasToIncreaseSize = component.hasToIncreaseSize(position);
            if (hasToIncreaseSize)  {
                break;
            }
        }
        for (GameComponent component : components) {
            component.setNewPoint(position, hasToIncreaseSize);
        }
    }

    @Override
    public void removeComponent(GameComponent component) {
        components.remove(component);
    }

    @Override
    public int getScore() {
        int score = 0;
        for (GameComponent component: components) {
            score += component.getScore();
        }

        return score;
    }

    @Override
    public Boolean checkCollide(Point point) {
        Boolean collide = false;
        for (GameComponent component : components ) {
            collide = component.checkCollide(point);
            if (collide) {
                break;
            }
        }

        return collide;
    }
}
