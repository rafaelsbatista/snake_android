package game.rafael.snake.component.fruit;

import android.graphics.Color;
import android.graphics.Paint;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;
import game.rafael.snake.strategy.RngStrategy;

public class SpoiledFruit extends SimpleFruit {
    public static int spoiledFruitExpirateTime = 200;

    int count = spoiledFruitExpirateTime;

    public SpoiledFruit(RngStrategy strategy, int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(strategy, numBlocksWide, numBlocksHigh, blockSize);
        paint.setColor(Color.rgb(173, 168, 168));
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        if (this.position == null && hasToIncreaseSize) {
            this.position = strategy.gerenatePoint();
            if (position != null) {
                count = spoiledFruitExpirateTime;
            }
        } else if (this.position != null) {
            count --;
        }

        if (count <= 0) {
            this.position = null;
        }

    }

    @Override
    public Boolean checkCollide(Point point) {
        return point.equals(this.position);
    }
}
