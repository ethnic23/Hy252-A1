package A14;

import java.util.Random;
import java.util.Scanner;

class Sudoku{
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args){
        int[][] brd = new int[9][9];
        int valid=0,invalid=0;
        boolean v = true;
        Scanner scanner = new Scanner(System.in);

        /*for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.println("Give a number from 0 to 9: ");
                brd[i][j]=scanner.nextInt();
            }
        }*/
        System.out.println("Give how many filled cells: ");

        int X=scanner.nextInt();
        System.out.println("How many number of boards: ");
        int N=scanner.nextInt();
        System.out.println("N="+N);
        System.out.println("X="+X);
        for(int i=0;i<N;i++) {
            brd = randomBoard(X);
            for (i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(brd[i][j] + " ");
                }
                System.out.println();
            }

            for (i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    v = isValidBoard(brd, i, j);
                }
            }
        /*if(v){
            if(isSolvableBoard(brd)){

            }
        }*/

            for (i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(brd[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    static int[][] randomBoard(int X){
        int count=0,r_i,r_j;
        int[][] brd = new int[9][9];
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                brd[i][j] = 0;
            }
        }
        while(count<X){
            Random randomGenerator = new Random();
            r_i = randomGenerator.nextInt(9);
            r_j = randomGenerator.nextInt(9);
            if(brd[r_i][r_j]==0){
               brd[r_i][r_j]= randomGenerator.nextInt(10);
               count++;
            }
        }
        return brd;
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

