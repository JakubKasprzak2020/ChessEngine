package Moves;

import Board.Square;
import Pieces.Color;
import Pieces.Piece;

public abstract class Castling extends Move {

    public Square kingsSquare;
    public Square rookSquare;
    public Piece rook;


    public Castling(Piece piece, Square square, Square[][] chessboard) {
        super(piece, square, chessboard);
    }

    public Castling(Piece piece, Square square, Square[][] chessboard, Square kingsSquare, Square rookSquare, Piece rook) {
        super(piece, square, chessboard);
        this.kingsSquare = kingsSquare;
        this.rookSquare = rookSquare;
        this.rook = rook;
    }

    public Square getKingsSquare() {
        return kingsSquare;
    }

    public void setKingsSquare(Square kingsSquare) {
        this.kingsSquare = kingsSquare;
    }

    public Square getRookSquare() {
        return rookSquare;
    }

    public void setRookSquare(Square rookSquare) {
        this.rookSquare = rookSquare;
    }

    public Piece getRook() {
        return rook;
    }

    public void setRook(Piece rook) {
        this.rook = rook;
    }

    @Override
    void makeMove() {
        Color color = piece.getColor();
        Move kingMove = new StandardMove(piece, kingsSquare, chessboard);
        kingMove.makeMove();
        Move rookMove = new StandardMove(rook, rookSquare, chessboard);
        rookMove.makeMove();
    }


}
