package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Piece;

public abstract class Move {

    public Piece piece;
    public Square square;
    public Square[][] chessboard;

    public Move(Piece piece, Square square, Square[][]  chessboard) {
        this.piece = piece;
        this.square = square;
        this.chessboard = chessboard;
    }

   abstract void makeMove();

}
