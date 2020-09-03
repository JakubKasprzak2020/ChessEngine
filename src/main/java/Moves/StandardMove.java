package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Piece;

public class StandardMove extends Move {

    public StandardMove(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
    }

    @Override
    public void makeMove() {
        Square startingSquare = piece.getSquare();
        startingSquare.setPiece(null);
        square.setPiece(piece);
        piece.setSquare(square);
    }
}
