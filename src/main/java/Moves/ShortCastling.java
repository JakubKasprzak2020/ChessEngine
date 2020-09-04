package Moves;

import Board.Square;
import Pieces.Color;
import Pieces.Piece;

public class ShortCastling extends Castling {


    public ShortCastling(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
        Color color = piece.getColor();
        if (color == Color.WHITE) {
            kingsSquare = chessboard[0][6];
            rookSquare = chessboard[0][5];
            rook = chessboard[0][7].getPiece();
        } else {
            kingsSquare = chessboard[7][6];
            rookSquare = chessboard[7][5];
            rook = chessboard[7][7].getPiece();
        }
    }

    @Override
    void makeMove() {
        super.makeMove();
    }

}












/*
OLD VERSION

package Moves;

        import Board.Square;
        import Pieces.Color;
        import Pieces.Piece;

public class ShortCastling extends Move {


    public ShortCastling(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
    }

    @Override
    void makeMove() {
        Color color = piece.getColor();
        Square kingsSquare;
        Square rookSquare;
        Piece rook;
        if (color == Color.WHITE) {
            kingsSquare = chessboard[0][6];
            rookSquare = chessboard[0][5];
            rook = chessboard[0][7].getPiece();
        } else {
            kingsSquare = chessboard[7][6];
            rookSquare = chessboard[7][5];
            rook = chessboard[7][7].getPiece();
        }
        Move kingMove = new StandardMove(piece, kingsSquare, chessboard);
        kingMove.makeMove();
        Move rookMove = new StandardMove(rook, rookSquare, chessboard);
        rookMove.makeMove();
    }
}*/
