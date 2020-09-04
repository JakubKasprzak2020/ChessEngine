package Moves;

import Board.Chessboard;
import Board.Square;
import Pieces.Color;
import Pieces.Pawn;
import Pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnPassantTest {

    @Test
    void EnPassantOnLeftWhiteCaptures() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startWhitePawnSquare = chessboard[4][2];
        Square finishWhitePawnSquare = chessboard[5][1];
        Square blackPawnSquare = chessboard[4][1];
        Piece whitePawn = new Pawn(Color.WHITE, startWhitePawnSquare);
        startWhitePawnSquare.setPiece(whitePawn);
        Piece blackPawn = new Pawn(Color.BLACK, blackPawnSquare);
        blackPawnSquare.setPiece(blackPawn);
        //when
        Move move = new EnPassant(whitePawn, finishWhitePawnSquare, chessboard);
        move.makeMove();
        //then
        assertNull(blackPawnSquare.getPiece());
        assertNull(startWhitePawnSquare.getPiece());
        assertEquals(whitePawn, finishWhitePawnSquare.getPiece());
        assertEquals(finishWhitePawnSquare, whitePawn.getSquare());
    }



    @Test
    void EnPassantOnRightBlackCaptures() {
        //given
        Chessboard board = new Chessboard();
        Square[][] chessboard = board.getBoard();
        Square startBlackPawnSquare = chessboard[3][2];
        Square finishBlackPawnSquare = chessboard[2][3];
        Square whitePawnSquare = chessboard[3][3];
        Piece blackPawn = new Pawn(Color.BLACK, startBlackPawnSquare);
        startBlackPawnSquare.setPiece(blackPawn);
        Piece whitePawn = new Pawn(Color.WHITE, whitePawnSquare);
        whitePawnSquare.setPiece(whitePawn);
        //when
        Move move = new EnPassant(blackPawn, finishBlackPawnSquare, chessboard);
        move.makeMove();
        //then
        assertNull(whitePawnSquare.getPiece());
        assertNull(startBlackPawnSquare.getPiece());
        assertEquals(blackPawn, finishBlackPawnSquare.getPiece());
        assertEquals(finishBlackPawnSquare, blackPawn.getSquare());
    }




}