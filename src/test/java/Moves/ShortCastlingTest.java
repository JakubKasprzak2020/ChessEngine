package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortCastlingTest {

    @Test
    void shortCastlingForWhite() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startKingSquare = chessboard[0][4];
        Square finishKingSquare = chessboard[0][6];
        Square startRookSquare = chessboard[0][7];
        Square finishRookSquare = chessboard[0][5];
        Piece king = new King(Color.WHITE, startKingSquare);
        Piece rook = new Rook(Color.WHITE, startRookSquare);
        startKingSquare.setPiece(king);
        startRookSquare.setPiece(rook);
        ShortCastling move = new ShortCastling(king, finishKingSquare, chessboard);
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
    void shortCastlingForBlack() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startKingSquare = chessboard[7][4];
        Square finishKingSquare = chessboard[7][6];
        Square startRookSquare = chessboard[7][7];
        Square finishRookSquare = chessboard[7][5];
        Piece king = new King(Color.BLACK, startKingSquare);
        Piece rook = new Rook(Color.BLACK, startRookSquare);
        startKingSquare.setPiece(king);
        startRookSquare.setPiece(rook);
        ShortCastling move = new ShortCastling(king, finishKingSquare, chessboard);
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