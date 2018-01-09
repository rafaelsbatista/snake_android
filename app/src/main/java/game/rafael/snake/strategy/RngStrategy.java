package game.rafael.snake.strategy;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.model.Point;

public abstract class RngStrategy {

    public GameComponent board;

    public RngStrategy(GameComponent board) {
        this.board = board;
    }

    public abstract Point gerenatePoint();

}
