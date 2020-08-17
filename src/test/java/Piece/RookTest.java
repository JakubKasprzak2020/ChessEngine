package Piece;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RookTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[0][0];
        Rook rook = new Rook(Color.WHITE, square);
        //when
        List<Square> list = rook.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[A2, A3, A4, A5, A6, A7, A8, B1, C1, D1, E1, F1, G1, H1]";
        //then
        assertEquals(expected, actual);
    }
}