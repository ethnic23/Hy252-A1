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
        int valid=0,invalid=0,unsolvable=0;
        boolean v = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give how many filled cells: ");
        int X=scanner.nextInt();
        System.out.println("How many number of boards: ");
        int N=scanner.nextInt();
        System.out.println("N="+N);
        System.out.println("X="+X);
        long start = System.currentTimeMillis();
        while(valid<10){
        for(int i=0;i<N;i++) {
            brd = randomBoard(X);
            System.out.println("Board #" + i);
            for (int k = 0; k < 9; k++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(brd[k][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            for (int k = 0; k < 9; k++) {
                for (int j = 0; j < 9; j++) {
                    v = isValidBoard(brd, k, j);
                }
            }
            if (v) {
                valid++;
                if (isSolvableBoard(brd)) {
                    brd = solve(brd);
                    System.out.println("Solution of Board #" + (i+1));
                    for (int k = 0; k < 9; k++) {
                        for (int j = 0; j < 9; j++) {
                            System.out.print(brd[k][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    unsolvable++;
                    System.out.println("Solution of Board #" + (i+1));
                    for (int k = 0; k < 9; k++) {
                        for (int j = 0; j < 9; j++) {
                            System.out.print(brd[k][j] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                invalid++;
                System.out.println("Solution of Board #" + (i+1));
                for (int k = 0; k < 9; k++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(brd[k][j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }

        }
        long end = System.currentTimeMillis();
        float sec = (end-start)/1000f;
        System.out.println("Empty cells per boards: "+X);
        System.out.println("Valid boards created: "+valid);
        System.out.println("Invalid boards created: "+invalid);
        System.out.println("Unsolvable boards created: "+unsolvable);
        System.out.println("Elapsed time in seconds: "+sec);
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
    static int[][] solve(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                    }
                }
            }
        }
      return board;
    }
}

