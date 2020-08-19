package Pieces;

import Board.Square;

import java.util.List;

public class Pawn implements Piece {

    private Color color;
    private Square square;

    public Pawn(Color color, Square square) {
        this.color = color;
        this.square = square;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Square> possibleMovesOnEmptyChessBoard(Square[][] board) {
        int x = square.getX();
        int y = square.getY();
        List<Square> collection = PieceMethod.listOfSquareFromMatrix(board);
        if (color == Color.WHITE && y == 1) {
            collection.removeIf(s -> s.getX() != x || (s.getY() != 2 && s.getY() != 3));
        } else if (color == Color.WHITE && y != 1) {
            collection.removeIf(s -> s.getX() != x || s.getY() - 1 != y);
        } else if (color == Color.BLACK && y == 6) {
            collection.removeIf(s -> s.getX() != x || (s.getY() != 5 && s.getY() != 4));
        } else if (color == Color.BLACK && y != 6) {
            collection.removeIf(s -> s.getX() != x || s.getY() + 1 != y);
        }
        return collection;
    }

    @Override
    public List<Square> possibleMovesWithObstacles(Square[][] board) {
        return null;
    }


}
