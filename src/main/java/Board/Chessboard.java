package Board;

public class Chessboard {

    private Square [][] board;

    public Chessboard() {
        initChessboard();
    }

    private void initChessboard(){
        board = new Square [8][8];
        for (int x = 0; x < board.length ; x++) {
            for (int y = 0; y < board[x].length ; y++) {
                board[x][y] = new Square();
                board[x][y].setX(x);
                board[x][y].setY(y);
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

}
