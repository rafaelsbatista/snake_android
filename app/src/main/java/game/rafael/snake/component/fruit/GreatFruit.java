package game.rafael.snake.component.fruit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import game.rafael.snake.model.Point;
import game.rafael.snake.strategy.RngStrategy;


public class GreatFruit extends SimpleFruit {
    public GreatFruit(RngStrategy strategy, int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(strategy, numBlocksWide, numBlocksHigh, blockSize);
        paint.setColor(Color.rgb(244, 65, 220));
    }

    @Override
    public void setNewPoint(Point position, Boolean hasToIncreaseSize) {
        if (this.position == null && hasToIncreaseSize) {
            this.position = strategy.gerenatePoint();
        } else {
            super.setNewPoint(position, hasToIncreaseSize);
        }
    }

    @Override
    public void addScore() {
        super.addScore(10);
    }
}
