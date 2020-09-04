
package Moves;

import Board.Square;
import Pieces.Piece;

public class EnPassant extends Move {


    public EnPassant(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
    }

    @Override
    void makeMove() {
        int xOfCapturedPiece = piece.getSquare().getX();
        int yOfCapturedPiece = square.getY();
        Move move = new StandardMove(piece, square, chessboard);
        move.makeMove();
        chessboard[xOfCapturedPiece][yOfCapturedPiece].setPiece(null);
    }
}

