package game.rafael.snake.component.board.decorator.core;


import game.rafael.snake.component.GameComponent;
import game.rafael.snake.component.board.decorator.BaseDecorator;
import game.rafael.snake.model.Point;

public class BorderWithSpaceBoardDecorator extends BaseDecorator {
    public BorderWithSpaceBoardDecorator(GameComponent component) {
        super(component);
    }

    @Override
    public void populatePoints() {
        points.add(new Point(0, 0));

        for (int i = 1; i < getNumBlocksWide() / 2 - 3 ; i++) {
            points.add(new Point(i, 0));
            points.add(new Point(i, getNumBlocksHigh() - 1 ));
        }

        for (int i = getNumBlocksWide() / 2 + 3; i < getNumBlocksWide(); i++) {
            points.add(new Point(i, 0));
            points.add(new Point(i, getNumBlocksHigh() - 1 ));
        }

        for (int i = 1; i < getNumBlocksHigh() / 2 - 3; i++) {
            points.add(new Point(0, i));
            points.add(new Point(getNumBlocksWide() - 1, i));
        }

        for (int i = getNumBlocksHigh() / 2 + 3; i < getNumBlocksHigh(); i++) {
            points.add(new Point(0, i));
            points.add(new Point(getNumBlocksWide() - 1, i));
        }
    }
}
