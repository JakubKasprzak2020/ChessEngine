package Pieces;

import Board.Square;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Knight implements Piece {

    private Color color;
    private Square square;

    public Knight(Color color, Square square) {
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
        collection.removeIf(s -> (s.getX() != x+2 || s.getY() != y-1) &&
                        (s.getX() != x+2 || s.getY() != y+1) &&
                        (s.getX() != x-2 || s.getY() != y-1) &&
                        (s.getX() != x-2 || s.getY() != y+1) &&
                        (s.getX() != x-1 || s.getY() != y-2) &&
                        (s.getX() != x-1 || s.getY() != y+2) &&
                        (s.getX() != x+1 || s.getY() != y-2) &&
                        (s.getX() != x+1 || s.getY() != y+2));
        return collection;
    }

    @Override
    public List<Square> possibleMovesWithObstacles(Square[][] board) {
        List<Square> collection = possibleMovesOnEmptyChessBoard(board);
        List<Square> copy = new ArrayList<>(collection);
        Iterator<Square> it = collection.iterator();
        while (it.hasNext()){
            Square next = it.next();
            if (next.isOccupiedByColor(color)){
                copy.remove(next);
            }
        }
        return copy;
    }


}
