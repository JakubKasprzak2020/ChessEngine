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
    }
}