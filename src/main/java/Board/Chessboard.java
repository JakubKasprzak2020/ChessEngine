package Board;

public class Chessboard {

    private Square [][] chessboard;

    public Chessboard() {
        initChessboard();
    }

    private void initChessboard(){
        chessboard = new Square [8][8];
        for (int x = 0; x < chessboard.length ; x++) {
            for (int y = 0; y < chessboard[x].length ; y++) {
                chessboard[x][y] = new Square();
                chessboard[x][y].setX(x);
                chessboard[x][y].setY(y);
            }
        }
    }

    public Square[][] getChessboard() {
        return chessboard;
    }

}
