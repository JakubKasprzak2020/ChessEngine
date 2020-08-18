package Pieces;

import Board.Square;

import java.util.List;

public interface Piece {

    public List<Square> possibleMovesOnEmptyChessBoard(Square [][] board);
    public List<Square> possibleMovesWithObstacles(Square[][] board);
    public Color getColor();


}
