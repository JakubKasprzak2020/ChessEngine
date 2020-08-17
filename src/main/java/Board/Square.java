package Board;

import Piece.Piece;

public class Square {

    private int x;
    private int y;
    private Piece piece;

    public Square(){
    }

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

        public boolean isOccupy(){
        if (piece == null){
            return false;
        } return true;
    }




    @Override
    public String toString() {
        String [] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String letter = letters[getX()];
        int number = getY()+1;
        return letter + number;
    }
}
