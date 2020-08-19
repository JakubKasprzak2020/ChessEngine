package Pieces;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[3][3];
        Piece knight = new Knight(Color.WHITE, square);
        //when
        List<Square> list = knight.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[B3, B5, C2, C6, E2, E6, F3, F5]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesOnEmptyChessBoardWithKnightInTheCorner() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[0][0];
        Piece knight = new Knight(Color.WHITE, square);
        //when
        List<Square> list = knight.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[B3, C2]";
        //then
        assertEquals(expected, actual);
    }





    @Test
    void possibleMovesWithObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[7][7]; //H8
        Square square2 = chessboard[5][6]; //F7
        Square square3 = chessboard[6][5]; //G6
        Piece knight = new Knight(Color.WHITE, square1);
        Piece rook = new Rook(Color.WHITE, square2); //white piece blocks F7
        Piece bishop = new Bishop(Color.BLACK, square3); // black piece to capture on G6
        square2.setPiece(rook);
        square3.setPiece(bishop);
        //when
        List<Square> list = knight.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[G6]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithFiveObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[3][3]; //D4
        Square square2 = chessboard[1][2]; //B3
        Square square3 = chessboard[4][5]; //E6
        Square square4 = chessboard[2][5]; //C6
        Square square5 = chessboard[5][2]; //F3
        Square square6 = chessboard[1][4]; //B5
        Piece knight1 = new Knight(Color.WHITE, square1);
        Piece knight2 = new Knight(Color.WHITE, square2);
        Piece knight3 = new Knight(Color.WHITE, square3);
        Piece knight4 = new Knight(Color.WHITE, square4);
        Piece knight5 = new Knight(Color.WHITE, square5);
        Piece knight6 = new Knight(Color.WHITE, square6);
        square1.setPiece(knight1);
        square2.setPiece(knight2);
        square3.setPiece(knight3);
        square4.setPiece(knight4);
        square5.setPiece(knight5);
        square6.setPiece(knight6);
        //when
        List<Square> list = knight1.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[C2, E2, F5]";
        //then
        assertEquals(expected, actual);
    }
}