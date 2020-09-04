package Moves;

import Board.Square;
import Pieces.Color;
import Pieces.Piece;

public class LongCastling extends Castling{

    public LongCastling(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
        Color color = piece.getColor();
        if (color == Color.WHITE) {
            kingsSquare = chessboard[0][2];
            rookSquare = chessboard[0][3];
            rook = chessboard[0][0].getPiece();
        } else {
            kingsSquare = chessboard[7][2];
            rookSquare = chessboard[7][3];
            rook = chessboard[7][0].getPiece();
        }
    }


    @Override
    void makeMove() {
        super.makeMove();
    }
}
