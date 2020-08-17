package Board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

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