package Pieces;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][1]; //A2
        Square square2 = chessboard[4][4]; //E5
        Square square3 = chessboard[5][6]; //F7
        Square square4 = chessboard[7][4]; //H5
        Piece pawn1 = new Pawn(Color.WHITE, square1);
        Piece pawn2 = new Pawn(Color.WHITE, square2);
        Piece pawn3 = new Pawn(Color.BLACK, square3);
        Piece pawn4 = new Pawn(Color.BLACK, square4);
        //when
        List<Square> list1 = pawn1.possibleMovesOnEmptyChessBoard(chessboard);
        List<Square> list2 = pawn2.possibleMovesOnEmptyChessBoard(chessboard);
        List<Square> list3 = pawn3.possibleMovesOnEmptyChessBoard(chessboard);
        List<Square> list4 = pawn4.possibleMovesOnEmptyChessBoard(chessboard);
        String actual1 = list1.toString();
        String expected1 = "[A3, A4]";
        String actual2 = list2.toString();
        String expected2 = "[E6]";
        String actual3 = list3.toString();
        String expected3 = "[F5, F6]";
        String actual4 = list4.toString();
        String expected4 = "[H4]";
        //then
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);


    }

    @Test
    void possibleMovesWithObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][1]; //A2
        Square square2 = chessboard[0][3]; //A4
        Square square3 = chessboard[5][6]; //F7
        Square square4 = chessboard[5][4]; //F5
        Square square5 = chessboard[5][3]; // F4
        Piece pawn1 = new Pawn(Color.WHITE, square1);
        Piece pawn2 = new Pawn(Color.WHITE, square2);
        Piece pawn3 = new Pawn(Color.BLACK, square3);
        Piece pawn4 = new Pawn(Color.BLACK, square4);
        Piece pawn5 = new Pawn(Color.WHITE, square5);
        square1.setPiece(pawn1);
        square2.setPiece(pawn2);
        square3.setPiece(pawn3);
        square4.setPiece(pawn4);
        square5.setPiece(pawn5);
        //when
        List<Square> list1 = pawn1.possibleMovesWithObstacles(chessboard);
        List<Square> list2 = pawn2.possibleMovesWithObstacles(chessboard);
        List<Square> list3 = pawn3.possibleMovesWithObstacles(chessboard);
        List<Square> list4 = pawn4.possibleMovesWithObstacles(chessboard);
        List<Square> list5 = pawn5.possibleMovesWithObstacles(chessboard);
        String actual1 = list1.toString();
        String expected1 = "[A3]";
        String actual2 = list2.toString();
        String expected2 = "[A5]";
        String actual3 = list3.toString();
        String expected3 = "[F6]";
        String actual4 = list4.toString();
        String expected4 = "[]";
        String actual5 = list5.toString();
        String expected5 = "[]";
        //then
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }


    @Test
    void possibleMovesWithCaptures() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][1]; //A2
        Square square2 = chessboard[1][2]; //B3
        Square square3 = chessboard[5][6]; //F7
        Square square4 = chessboard[4][5]; //E6
        Square square5 = chessboard[6][5]; //G6
        Piece pawn1 = new Pawn(Color.WHITE, square1);
        Piece pawn2 = new Pawn(Color.BLACK, square2);
        Piece pawn3 = new Pawn(Color.BLACK, square3);
        Piece pawn4 = new Pawn(Color.WHITE, square4);
        Piece pawn5 = new Pawn(Color.WHITE, square5);
        square1.setPiece(pawn1);
        square2.setPiece(pawn2);
        square3.setPiece(pawn3);
        square4.setPiece(pawn4);
        square5.setPiece(pawn5);
        //when
        List<Square> list1 = pawn1.possibleMovesWithObstacles(chessboard);
        List<Square> list2 = pawn2.possibleMovesWithObstacles(chessboard);
        List<Square> list3 = pawn3.possibleMovesWithObstacles(chessboard);
        List<Square> list4 = pawn4.possibleMovesWithObstacles(chessboard);
        List<Square> list5 = pawn5.possibleMovesWithObstacles(chessboard);
        String actual1 = list1.toString();
        String expected1 = "[A3, A4, B3]";
        String actual2 = list2.toString();
        String expected2 = "[B2, A2]"; // first normal moves, than captures
        String actual3 = list3.toString();
        String expected3 = "[F5, F6, E6, G6]";
        String actual4 = list4.toString();
        String expected4 = "[E7, F7]";
        String actual5 = list5.toString();
        String expected5 = "[G7, F7]";
        //then
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }



}