package Moves;

import Board.Square;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class MovesFinder {

    public List <Move> findMovesOfPiece(Piece piece, Square[][] chessboard){
        List <Move> result = new ArrayList<>();
        List<Square> listSquare = piece.possibleMovesWithObstacles(chessboard);
        for (Square s : listSquare){
            result.add(new StandardMove(piece, s, chessboard));
        }
        return result;
    }









}
