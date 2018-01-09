package game.rafael.snake.strategy.core;

import java.util.List;
import java.util.Random;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;
import game.rafael.snake.strategy.RngStrategy;

public class SameProbabilityRngStrategy extends RngStrategy {


    public SameProbabilityRngStrategy(GameComponent board) {
        super(board);
    }

    @Override
    public Point gerenatePoint() {
        List<Point> pointList = board.getPoints();
        Random random = new Random();
        Point point;
        do {
            int bobX = random.nextInt(board.getNumBlocksWide() - 2) + 1;
            int bobY = random.nextInt(board.getNumBlocksHigh() - 2) + 1;
            point = new Point(bobX, bobY);
        } while (pointList.contains(point));

        return point;
    }
}
