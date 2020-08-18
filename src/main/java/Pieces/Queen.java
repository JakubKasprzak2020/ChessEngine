package Pieces;

import Board.Square;

import java.util.List;

public class Queen implements Piece{

    private Color color;
    private Square square;
    private Rook rook;
    private Bishop bishop;

    public Queen(Color color, Square square) {
        this.color = color;
        this.square = square;
        rook = new Rook(color, square);
        bishop = new Bishop(color, square);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Square> possibleMovesOnEmptyChessBoard(Square[][] board) {
        List <Square> firstCollection = rook.possibleMovesOnEmptyChessBoard(board);
        List <Square> secondCollection = bishop.possibleMovesOnEmptyChessBoard(board);
        firstCollection.addAll(secondCollection);
        return firstCollection;
    }

    @Override
    public List<Square> possibleMovesWithObstacles(Square[][] board) {
        List <Square> firstCollection = rook.possibleMovesWithObstacles(board);
        List <Square> secondCollection = bishop.possibleMovesWithObstacles(board);
        firstCollection.addAll(secondCollection);
        return firstCollection;
    }


}
