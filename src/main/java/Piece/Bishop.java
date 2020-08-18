package Piece;

import Board.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Bishop implements Piece {

    private Color color;
    private Square square;

    public Bishop(Color color, Square square) {
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
        collection.removeIf(s -> (s.getX() - s.getY() != x - y && s.getX() + s.getY() != x + y)
                || (s.getX() == x && s.getY() == y));
        return collection;
    }

    @Override
    public List<Square> possibleMovesWithObstacles(Square[][] board) {
        List<Square> collection = possibleMovesOnEmptyChessBoard(board);
        List<Square> copy = new ArrayList<>(collection);
        Iterator<Square> it = collection.iterator();
        while (it.hasNext()){
            Square next = it.next();
            if (next.isOccupy() && next.getX() + next.getY() == square.getX() + square.getY()){
                if (next.getY() > square.getY()){
                    copy.removeIf(sq -> sq.getY()>next.getY() && sq.getY()+sq.getX() == next.getY()+next.getX());
                } else {
                    copy.removeIf(sq -> sq.getY()<next.getY() && sq.getY()+sq.getX() == next.getY()+next.getX());
                }
            }
            if (next.isOccupy() && next.getX() - next.getY() == square.getX() - square.getY()){
                if (next.getX() > square.getX()){
                    copy.removeIf(sq -> sq.getX()>next.getX() && sq.getY()-sq.getX() == next.getY()-next.getX());
                } else {
                    copy.removeIf(sq -> sq.getX()<next.getX() && sq.getY()-sq.getX() == next.getY()-next.getX());
                }
            }
            if (next.isOccupy() && next.getPiece().getColor().equals(color)){
                copy.remove(next);
            }
        }
        return copy;
    }


}
