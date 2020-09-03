package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Bishop;
import Pieces.Color;
import Pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardMoveTest {

    @Test
    void makeMove() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square start = chessboard[3][3];
        Square finish = chessboard[4][4];
        Piece bishop = new Bishop(Color.BLACK, start);
        start.setPiece(bishop);
        StandardMove move = new StandardMove(bishop, finish, chessboard);
        //when
        move.makeMove();
        //then
        assertNull(start.getPiece());
        assertEquals(bishop, finish.getPiece());
        assertEquals(finish, bishop.getSquare());
    }
}
