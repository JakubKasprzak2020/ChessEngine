package Board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @Test
    void getChessboard() {
        //given
        Chessboard board = new Chessboard();
        Square [][] chessboard = board.getChessboard();
        //when
        Square testSquare = new Square(5,5,null);
        Square secondTestSquare = new Square(3,7,null);
        //then
        assertEquals(testSquare.getX(),chessboard[5][5].getX());
        assertEquals(testSquare.getY(),chessboard[5][5].getY());
        assertEquals(testSquare.getPiece(),chessboard[5][5].getPiece());
        assertEquals(secondTestSquare.getX(),chessboard[3][7].getX());
        assertEquals(secondTestSquare.getY(),chessboard[3][7].getY());
        assertEquals(secondTestSquare.getPiece(),chessboard[3][7].getPiece());
    }
}