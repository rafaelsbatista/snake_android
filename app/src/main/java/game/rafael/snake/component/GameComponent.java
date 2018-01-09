package game.rafael.snake.component;


import android.graphics.Canvas;

import java.util.List;

import game.rafael.snake.model.Point;

public abstract class GameComponent {

    int numBlocksWide;
    int numBlocksHigh;
    int blockSize;
    Integer score;


    public GameComponent(int numBlocksWide, int numBlocksHigh, int blockSize) {
        score = new Integer(0);
        this.numBlocksWide = numBlocksWide;
        this.numBlocksHigh = numBlocksHigh;
        this.blockSize = blockSize;
    }

    public int getNumBlocksWide() {
        return numBlocksWide;
    }

    public int getNumBlocksHigh() {
        return numBlocksHigh;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void addScore() {

    }
    protected void addScore(int i) {
        score += i;
    }

    public int getScore() {
        return this.score;
    }

    public Boolean hasToIncreaseSize(Point position)  {
        return false;
    }

    public abstract void draw(Canvas canvas);

    public abstract List<Point> getPoints();

    public void setNewPoint(Point position) {
        setNewPoint(position, false);
    }

    public abstract void setNewPoint(Point position, Boolean hasToIncreaseSize);

    public  abstract Boolean checkCollide(Point point);

    public void addComponent(GameComponent component) {
    }

    public void removeComponent(GameComponent component) {
    }
}
