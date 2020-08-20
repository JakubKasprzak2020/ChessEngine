package Board;

import Pieces.Piece;
import Pieces.Rook;
import org.junit.jupiter.api.Test;

import static Pieces.Color.BLACK;
import static Pieces.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void isOccupied() {
        //given
        Square square1 = new Square(3,3,null);
        Square square2 = new Square(0,0,null);
        Piece rook = new Rook(BLACK, square2);
        //when
        square2.setPiece(rook);
        //then
        assertFalse(square1.isOccupied());
        assertTrue(square2.isOccupied());
    }

    @Test
    void isOccupiedByColor(){
        //given
        Square square1 = new Square(0,0,null);
        Square square2 = new Square(1,1,null);
        Square square3 = new Square(2,2,null);
        Piece rook1 = new Rook(BLACK, square2);
        Piece rook2 = new Rook(WHITE, square3);
        //when
        square2.setPiece(rook1);
        square3.setPiece(rook2);
        //then
        assertFalse(square1.isOccupiedByColor(WHITE));
        assertFalse(square2.isOccupiedByColor(WHITE));
        assertTrue(square3.isOccupiedByColor(WHITE));
    }

    @Test
    void testToString() {
        //given
        Square square1 = new Square(3,3,null);
        Square square2 = new Square(0,0,null);
        Square square3 = new Square(7,7,null);
        Square square4 = new Square(2,6,null);
        Square square5 = new Square(1,5,null);
        Square square6 = new Square(6,3,null);
        //when
        String text1 = square1.toString();
        String text2 = square2.toString();
        String text3 = square3.toString();
        String text4 = square4.toString();
        String text5 = square5.toString();
        String text6 = square6.toString();
        //then
        assertEquals("D4", text1 );
        assertEquals("A1", text2 );
        assertEquals("H8", text3 );
        assertEquals("C7", text4 );
        assertEquals("B6", text5 );
        assertEquals("G4", text6 );
    }
}