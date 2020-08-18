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

    @Test
    void possibleMovesWithObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][0];
        Square square2 = chessboard[0][1];
        Rook rook1 = new Rook(Color.WHITE, square1);
        Rook rook2 = new Rook(Color.BLACK, square2);
        square2.setPiece(rook2);
        //when
        List<Square> list = rook1.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[A2, B1, C1, D1, E1, F1, G1, H1]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithTwoObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[4][0];
        Square square2 = chessboard[3][0];
        Square square3 = chessboard[5][0];
        Rook rook1 = new Rook(Color.WHITE, square1);
        Rook rook2 = new Rook(Color.WHITE, square2);
        Rook rook3 = new Rook(Color.WHITE, square3);
        square2.setPiece(rook2);
        square3.setPiece(rook3);
        //when
        List<Square> list = rook1.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[E2, E3, E4, E5, E6, E7, E8]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithFourObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[4][5]; // E6
        Square square2 = chessboard[4][3]; // E4
        Square square3 = chessboard[4][7]; // E8
        Square square4 = chessboard[2][5]; // C6
        Square square5 = chessboard[6][5]; // G6
        Rook rook1 = new Rook(Color.WHITE, square1);
        Rook rook2 = new Rook(Color.WHITE, square2);
        Rook rook3 = new Rook(Color.WHITE, square3);
        Rook rook4 = new Rook(Color.WHITE, square4);
        Rook rook5 = new Rook(Color.BLACK, square5); // One Rook to capture
        square2.setPiece(rook2);
        square3.setPiece(rook3);
        square4.setPiece(rook4);
        square5.setPiece(rook5);
        //when
        List<Square> list = rook1.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[D6, E5, E7, F6, G6]";
        //then
        assertEquals(expected, actual);

    }




}