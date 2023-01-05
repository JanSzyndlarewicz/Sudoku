public class SudokuBoard {
    private int dimension;
    private int[][] board;

    public SudokuBoard(int dimension) {
        if (dimension == 3 || dimension == 9) {
            board = new int[dimension][dimension];
        }
    }

    public void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}