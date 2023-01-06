import java.util.Random;
import java.util.Scanner;

public class SudokuBoard {
    private int dimension;
    private int[][] board;


    public SudokuBoard(int dimension) {
        if (dimension == 3 || dimension == 9) {
            board = new int[dimension][dimension];

        }
    }

    private boolean allNumbersDrawn(int[] tab){
        for (int j : tab) {
            if (j == 0) {
                return false;
            }
        }
        return true;
    }

    public void startSolving(){
        Scanner scanner = new Scanner(System.in);
        do{
            printBoard();
            int row, column, numberToFill;
            do{
                System.out.println("Podaj koordynaty: ");
                System.out.print("Podaj wiersz: ");
                row = scanner.nextInt();

                System.out.print("Podaj kolumnę: ");
                column = scanner.nextInt();

            }while (board[row-1][column-1]!=0);

            System.out.println("Podaj liczbę do wpisania: ");
            numberToFill = scanner.nextInt();

            if(isReadyToFillIn(board, row, column, numberToFill)){
                board[row][column] = numberToFill;
            }
            else{
                System.out.println("Wrong number");
            }
        }while (true);

    }

    public int[][] newBoard(int level){
        solveBoard();

        if(level>0 && level<10){
            Random random = new Random();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(random.nextInt(13)<level){
                        board[i][j] = 0;
                    }
                }
            }
        }

        return board;
    }

    public boolean solveBoard() {
        Random random = new Random();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0){
                        int[] tab = new int[9];
                        do{
                            int numberToTry = random.nextInt(9)+1;
                            tab[numberToTry-1] = numberToTry;
                            if(isReadyToFillIn(board, i, j, numberToTry)){
                                board[i][j] = numberToTry;

                                if(solveBoard()){
                                    return true;
                                }
                                else {
                                    board[i][j] = 0;
                                }
                            }
                        }while(!allNumbersDrawn(tab));



                    return false;
                }
            }
        }
        return true;
    }

    public boolean isReadyToFillIn(int[][] board, int row, int column, int valueToFillIn) {
        for (int k = 0; k < board.length; k++) {
            if (board[row][k] == valueToFillIn || board[k][column] == valueToFillIn) {
                return false;
            }
        }

        for (int k = (row / 3) * 3; k < (row / 3) * 3 + 3; k++) {
            for (int l = (column / 3) * 3; l < (column / 3) * 3 + 3; l++) {
                if (k != row && l != column && board[k][l] == valueToFillIn) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for(int k=0; k< board.length; k++){
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if((j+1)%3==0){
                    System.out.print(" | ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println();
            if((i+1)%3==0){
                for(int k=0; k< board.length; k++){
                    System.out.print("----");
                }
                System.out.println();
            }

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