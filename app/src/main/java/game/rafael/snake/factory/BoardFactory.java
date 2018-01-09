package game.rafael.snake.factory;

import game.rafael.snake.component.GameComponent;
import game.rafael.snake.component.board.GameBoard;
import game.rafael.snake.component.board.decorator.core.BorderWithSpaceBoardDecorator;
import game.rafael.snake.component.board.decorator.core.FullBorderBoardDecorator;
import game.rafael.snake.component.fruit.GreatFruit;
import game.rafael.snake.component.fruit.SimpleFruit;
import game.rafael.snake.component.fruit.SpoiledFruit;
import game.rafael.snake.component.snake.BlockSnake;
import game.rafael.snake.component.snake.Snake;
import game.rafael.snake.model.Point;
import game.rafael.snake.strategy.core.SameProbabilityRngStrategy;
import game.rafael.snake.strategy.core.UncertainRngStrategy;

public abstract class BoardFactory {

    public static GameComponent createNivel1Board(int numBlocksWide, int numBlocksHigh, int blockSize, Point initialPosition) {
        GameComponent nivel1Board;

        nivel1Board = new GameBoard(numBlocksWide, numBlocksHigh, blockSize);
        nivel1Board.addComponent(new SimpleFruit(new SameProbabilityRngStrategy(nivel1Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel1Board.addComponent(new SpoiledFruit(new SameProbabilityRngStrategy(nivel1Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel1Board.addComponent(new Snake(initialPosition ,numBlocksWide, numBlocksHigh, blockSize));

        return nivel1Board;
    }

    public static GameComponent createNivel2Board(int numBlocksWide, int numBlocksHigh, int blockSize, Point initialPosition) {
        GameComponent nivel2Board;

        nivel2Board = new FullBorderBoardDecorator(new GameBoard(numBlocksWide, numBlocksHigh, blockSize));
        nivel2Board.addComponent(new SimpleFruit(new SameProbabilityRngStrategy(nivel2Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel2Board.addComponent(new SpoiledFruit(new SameProbabilityRngStrategy(nivel2Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel2Board.addComponent(new BlockSnake(initialPosition ,numBlocksWide, numBlocksHigh, blockSize));

        return nivel2Board;
    }

    public static GameComponent createNivel3Board(int numBlocksWide, int numBlocksHigh, int blockSize, Point initialPosition) {
        GameComponent nivel3Board;

        nivel3Board = new BorderWithSpaceBoardDecorator(new GameBoard(numBlocksWide, numBlocksHigh, blockSize));
        nivel3Board.addComponent(new SimpleFruit(new SameProbabilityRngStrategy(nivel3Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel3Board.addComponent(new GreatFruit(new UncertainRngStrategy(nivel3Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel3Board.addComponent(new SpoiledFruit(new UncertainRngStrategy(nivel3Board),numBlocksWide, numBlocksHigh, blockSize));
        nivel3Board.addComponent(new BlockSnake(initialPosition ,numBlocksWide, numBlocksHigh, blockSize));

        return nivel3Board;
    }
}
