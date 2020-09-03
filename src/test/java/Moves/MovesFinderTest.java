package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Color;
import Pieces.Pawn;
import Pieces.Piece;
import org.junit.jupiter.api.Test;
import java.util.List;



import static org.junit.jupiter.api.Assertions.*;

class MovesFinderTest {

    @Test
    void findMovesOfPieceWithOnePosibility() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square square = chessboard [0][3];
        Piece pawn = new Pawn(Color.WHITE, square);
        //when
        MovesFinder movesFinder = new MovesFinder();
        List<Move> actual = movesFinder.findMovesOfPiece(pawn, chessboard);
        //then
     actual.get(0).makeMove();
        assertEquals(1, actual.size());
        assertEquals(pawn, chessboard[0][4].getPiece());


    }

}