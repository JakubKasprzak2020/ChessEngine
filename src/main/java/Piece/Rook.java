package Piece;

import Board.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    public List<Square> possibleMovesWithObstacles(Square [][] board) {
        List<Square> collection = possibleMovesOnEmptyChessBoard(board);
        List<Square> copy = new ArrayList<>(collection);
        Iterator <Square> it = collection.iterator();
            while (it.hasNext()){
                Square next = it.next();
                if (next.isOccupy() && next.getX() == square.getX()){
                    if (next.getY() > square.getY()){
                        copy.removeIf(sq -> sq.getY()>next.getY());
                    } else {
                        copy.removeIf(sq -> sq.getY()<next.getY());
                    }
                }
                if (next.isOccupy() && next.getY() == square.getY()){
                    if (next.getX() > square.getX()){
                        copy.removeIf(sq -> sq.getX()>next.getX());
                    } else {
                        copy.removeIf(sq -> sq.getX()<next.getX());
                    }
                }
                if (next.isOccupy() && next.getPiece().getColor().equals(color)){
                    copy.remove(next);
                }
            }
        return copy;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
