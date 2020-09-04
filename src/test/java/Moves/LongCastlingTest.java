package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Color;
import Pieces.King;
import Pieces.Piece;
import Pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongCastlingTest {

    @Test
    void longCastlingForWhite() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startKingSquare = chessboard[0][4];
        Square finishKingSquare = chessboard[0][2];
        Square startRookSquare = chessboard[0][0];
        Square finishRookSquare = chessboard[0][3];
        Piece king = new King(Color.WHITE, startKingSquare);
        Piece rook = new Rook(Color.WHITE, startRookSquare);
        startKingSquare.setPiece(king);
        startRookSquare.setPiece(rook);
        LongCastling move = new LongCastling(king, finishKingSquare, chessboard);
        //when
        move.makeMove();
        //then
        assertNull(startKingSquare.getPiece());
        assertNull(startRookSquare.getPiece());
        assertEquals(king, finishKingSquare.getPiece());
        assertEquals(rook, finishRookSquare.getPiece());
        assertEquals(finishKingSquare, king.getSquare());
        assertEquals(finishRookSquare, rook.getSquare());
    }

    @Test
    void longCastlingForBlack() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startKingSquare = chessboard[7][4];
        Square finishKingSquare = chessboard[7][2];
        Square startRookSquare = chessboard[7][0];
        Square finishRookSquare = chessboard[7][3];
        Piece king = new King(Color.BLACK, startKingSquare);
        Piece rook = new Rook(Color.BLACK, startRookSquare);
        startKingSquare.setPiece(king);
        startRookSquare.setPiece(rook);
        LongCastling move = new LongCastling(king, finishKingSquare, chessboard);
        //when
        move.makeMove();
        //then
        assertNull(startKingSquare.getPiece());
        assertNull(startRookSquare.getPiece());
        assertEquals(king, finishKingSquare.getPiece());
        assertEquals(rook, finishRookSquare.getPiece());
        assertEquals(finishKingSquare, king.getSquare());
        assertEquals(finishRookSquare, rook.getSquare());
    }



}