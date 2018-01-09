package game.rafael.snake.component.snake;


import game.rafael.snake.model.Point;

public class BlockSnake extends Snake {
    public BlockSnake(Point initialPosition, int numBlocksWide, int numBlocksHigh, int blockSize) {
        super(initialPosition, numBlocksWide, numBlocksHigh, blockSize);
    }

    @Override
    public Boolean checkCollide(Point point) {
        return positions.contains(point);
    }
}
