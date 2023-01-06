public class Main {


    public static void main(String[] args) {

        SudokuBoard sudokuBoard = new SudokuBoard(9);

        sudokuBoard.solveBoard();
        sudokuBoard.printBoard();

        sudokuBoard.newBoard(3);
        sudokuBoard.printBoard();

        sudokuBoard.startSolving();
        //sudokuBoard.printBoardSolved();
        //sudokuBoard.printBoardToSolve();
        //sudokuBoard.solveBoard();



    }
}