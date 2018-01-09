package game.rafael.snake.strategy.core;

import java.util.Random;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;

public class UncertainRngStrategy extends SameProbabilityRngStrategy {
    public UncertainRngStrategy(GameComponent board) {
        super(board);
    }

    @Override
    public Point gerenatePoint() {
        Random random = new Random();

        if (random.nextInt(100) < 10) {
            return super.gerenatePoint();
        } else {
            return null;
        }
    }
}
