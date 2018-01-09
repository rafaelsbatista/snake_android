package game.rafael.snake.model;

/**
 * Created by rafael on 1/7/18.
 */

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point pointObj = (Point) obj;
        return this.getX() == pointObj.getX() && this.getY() == pointObj.getY();
    }
}
