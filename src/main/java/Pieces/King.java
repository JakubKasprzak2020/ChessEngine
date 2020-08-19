package Pieces;

import Board.Square;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class King implements Piece {

    private Color color;
    private Square square;

    public King(Color color, Square square) {
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
        collection.removeIf(s -> (s.getX() != x || s.getY() != y-1) &&
                (s.getX() != x || s.getY() != y+1) &&
                (s.getX() != x+1 || s.getY() != y) &&
                (s.getX() != x-1 || s.getY() != y) &&
                (s.getX() != x+1 || s.getY() != y+1) &&
                (s.getX() != x+1 || s.getY() != y-1) &&
                (s.getX() != x-1 || s.getY() != y-1) &&
                (s.getX() != x-1 || s.getY() != y+1));
        return collection;
    }

    @Override
    public List<Square> possibleMovesWithObstacles(Square[][] board) {
        List<Square> collection = possibleMovesOnEmptyChessBoard(board);
        List<Square> copy = new ArrayList<>(collection);
        Iterator<Square> it = collection.iterator();
        while (it.hasNext()){
            Square next = it.next();
            if (PieceMethod.isSquareOccupiedByMyColor(next, color)){
                copy.remove(next);
            }
        }
        return copy;
    }


}
