package Pieces;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[0][7]; //A8
        Piece queen = new Queen(Color.WHITE, square);
        //when
        List<Square> list = queen.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[A1, A2, A3, A4, A5, A6, A7, B8, C8, D8, E8, F8, G8, H8, B7, C6, D5, E4, F3, G2, H1]"; // first rook moves, than bishop moves
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesWithTwoObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][7]; //A8
        Square square2 = chessboard[6][7]; //G8
        Square square3 = chessboard[3][4]; //D5
        Piece queen = new Queen(Color.WHITE, square1);
        Piece rook1 = new Rook(Color.WHITE, square2);
        Piece rook2 = new Rook(Color.BLACK, square3);
        square2.setPiece(rook1);
        square3.setPiece(rook2);
        //when
        List<Square> list = queen.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[A1, A2, A3, A4, A5, A6, A7, B8, C8, D8, E8, F8, B7, C6, D5]"; // first rook moves, than bishop moves
        //then
        assertEquals(expected, actual);
    }


    @Test
    void possibleMovesWithThreeObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[0][0]; //A1
        Square square2 = chessboard[0][1]; //A2
        Square square3 = chessboard[1][0]; //B1
        Square square4 = chessboard[1][1]; //B2
        Piece queen = new Queen(Color.WHITE, square1);
        Piece rook1 = new Rook(Color.WHITE, square2);
        Piece rook2 = new Rook(Color.WHITE, square3);
        Piece rook3 = new Rook(Color.BLACK, square4);
        square2.setPiece(rook1);
        square3.setPiece(rook2);
        square4.setPiece(rook3);
        //when
        List<Square> list = queen.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[B2]"; // first rook moves, than bishop moves
        //then
        assertEquals(expected, actual);
    }



}