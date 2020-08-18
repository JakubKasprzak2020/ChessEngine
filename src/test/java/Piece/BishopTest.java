package Piece;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[3][3];
        Piece bishop = new Bishop(Color.BLACK, square);
        //when
        List<Square> list = bishop.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[A1, A7, B2, B6, C3, C5, E3, E5, F2, F6, G1, G7, H8]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][0];
        Square square2 = chessboard[2][2];
        Piece bishop = new Bishop(Color.WHITE, square1);
        Piece rook = new Rook(Color.WHITE, square2);
        square2.setPiece(rook);
        //when
        List<Square> list = bishop.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[B2]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithTwoObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[5][3]; //F4
        Square square2 = chessboard[4][2]; //E3
        Square square3 = chessboard[4][4]; //E5
        Piece bishop = new Bishop(Color.WHITE, square1);
        Piece rook1 = new Rook(Color.WHITE, square2);
        Piece rook2 = new Rook(Color.BLACK, square3); //black to capture
        square2.setPiece(rook1);
        square3.setPiece(rook2);
        //when
        List<Square> list = bishop.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[E5, G3, G5, H2, H6]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithFourObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[2][4]; //C5
        Square square2 = chessboard[0][2]; //A3
        Square square3 = chessboard[4][6]; //E7
        Square square4 = chessboard[1][5]; //B6
        Square square5 = chessboard[5][1]; //F2
        Piece bishop = new Bishop(Color.WHITE, square1);
        Piece rook1 = new Rook(Color.WHITE, square2);
        Piece rook2 = new Rook(Color.WHITE, square3);
        Piece rook3 = new Rook(Color.BLACK, square4); //black to capture
        Piece rook4 = new Rook(Color.BLACK, square5); //black to capture
        square2.setPiece(rook1);
        square3.setPiece(rook2);
        square4.setPiece(rook3);
        square5.setPiece(rook4);
        //when
        List<Square> list = bishop.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[B4, B6, D4, D6, E3, F2]";
        //then
        assertEquals(expected, actual);
    }



}