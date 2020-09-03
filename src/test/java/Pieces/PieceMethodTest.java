package Pieces;

import Board.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PieceMethodTest {

    @Test
    void listOfSquareFromMatrix() {
        //given
        Square square1 = new Square(1, 2, null);
        Square square2 = new Square(2, 4, null);
        Square square3 = new Square(5, 0, null);
        Square square4 = new Square(7, 7, null);
        Square[][] matrix = {
                {square1, square2},
                {square3, square4}
        };
        List<Square> list = new ArrayList<>();
        list.add(square1);
        list.add(square2);
        list.add(square3);
        list.add(square4);
        //when
        List<Square> secondList = PieceMethod.listOfSquareFromMatrix(matrix);
        //then
        assertEquals(list, secondList);

    }
}