package Piece;

import Board.Square;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rook implements Piece {

    private Color color;
    private Square square;

    public void setColor(Color color) {
        this.color = color;
    }

    public Rook(Color color, Square square) {
        this.color = color;
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public List<Square> possibleMovesOnEmptyChessBoard(Square [][] board) {
        int x = square.getX();
        int y = square.getY();
        List<Square> collection = Arrays.stream(board)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        collection.removeIf(s -> (s.getX()!=x && s.getY()!=y) || (s.getX()==x && s.getY()==y));
        return collection;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
