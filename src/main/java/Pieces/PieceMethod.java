package Pieces;

import Board.Square;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PieceMethod {


    public static List<Square> listOfSquareFromMatrix (Square [][] board) {
        List<Square> collection = Arrays.stream(board)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        return collection;
    }



    public static boolean isSquareOccupiedByMyColor(Square square, Color color ) {
        if (!square.isOccupy()) {
            return false;
        }
        return square.getPiece().getColor().equals(color);
    }

}
