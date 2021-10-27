package A14;

import java.util.Scanner;

public class Sudoku{
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static int main(){
        int[][] brd = new int[9][9];
        int valid=0,invalid=0;
        boolean v = true;
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.println("Give a number from 0 to 9: ");
                brd[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<9;i++){
            for(int j =0;j<9;j++){
               v = isValidBoard(brd,i,j);
            }
        }
        if(v){
            if(isSolvableBoard(brd)){

            }
        }
        return 0;
    }
    static int randomBoard(int X){
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){

            }
        }
    }
    static boolean isValidBoard(int[][] board, int row, int column) {
        return BacktrackingAlgorithm.rowConstraint(board, row) &&
                BacktrackingAlgorithm.columnConstraint(board, column) &&
                BacktrackingAlgorithm.subsectionConstraint(board, row, column);
    }
    static boolean isSolvableBoard(int[][] brd){
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (brd[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        brd[row][column] = k;
                        if (isValidBoard(brd, row, column) && isSolvableBoard(brd)) {
                            return true;
                        }
                        brd[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

