package Pieces;

import Board.Chessboard;
import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void possibleMovesOnEmptyChessBoard() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[4][4]; //E5
        Piece king = new King(Color.WHITE, square);
        //when
        List<Square> list = king.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[D4, D5, D6, E4, E6, F4, F5, F6]";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void possibleMovesOnEmptyChessBoardWithKingInTheCorner() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square = chessboard[7][0]; //H1
        Piece king = new King(Color.WHITE, square);
        //when
        List<Square> list = king.possibleMovesOnEmptyChessBoard(chessboard);
        String actual = list.toString();
        String expected = "[G1, G2, H2]";
        //then
        assertEquals(expected, actual);
    }



    @Test
    void possibleMovesWithObstacles() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getChessboard();
        Square square1 = chessboard[3][2]; //D3
        Square square2 = chessboard[2][2]; //C3
        Square square3 = chessboard[4][3]; //E4
        Piece king = new King(Color.WHITE, square1);
        Piece rook = new Rook(Color.WHITE, square2); //white piece blocks C3
        Piece bishop = new Bishop(Color.BLACK, square3); // black piece to capture on E4
        square2.setPiece(rook);
        square3.setPiece(bishop);
        //when
        List<Square> list = king.possibleMovesWithObstacles(chessboard);
        String actual = list.toString();
        String expected = "[C2, C4, D2, D4, E2, E3, E4]";
        //then
        assertEquals(expected, actual);
    }
}