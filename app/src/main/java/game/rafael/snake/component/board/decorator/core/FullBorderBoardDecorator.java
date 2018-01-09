package game.rafael.snake.component.board.decorator.core;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.component.board.decorator.BaseDecorator;
import game.rafael.snake.model.Point;


public class FullBorderBoardDecorator extends BaseDecorator {

    public FullBorderBoardDecorator(GameComponent component) {
        super(component);
    }

    @Override
    public void populatePoints() {
        points.add(new Point(0, 0));

        for (int i = 1; i < getNumBlocksWide() ; i++) {
            points.add(new Point(i, 0));
            points.add(new Point(i, getNumBlocksHigh() - 1 ));
        }

        for (int i = 1; i < getNumBlocksHigh(); i++) {
            points.add(new Point(0, i));
            points.add(new Point(getNumBlocksWide() - 1, i));
        }
    }
}
