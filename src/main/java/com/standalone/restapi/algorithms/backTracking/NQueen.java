package com.standalone.restapi.algorithms.backTracking;

public class NQueen {

    int queenCount;
    int[][] input;

    public static void main(String[] args) {
        NQueen queen = new NQueen();
        int qCount = 4;
        queen.findQueenSquare(qCount);
    }

    private void findQueenSquare(int count) {
        queenCount = count;
        input = new int[queenCount][queenCount];

        if (trackSquare(0)) {
            for (int i = 0; i < queenCount; i++) {
                for (int j = 0; j < queenCount; j++) {
                    if (input[i][j] == 1) {
                        System.out.print("Q");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No perfect squares to place queen");
        }

    }

    private boolean trackSquare(int row) {
        if (row == queenCount) {
            return true;
        } else {
            for (int column = 0; column < queenCount; column++) {
                if (checkSquare(row, column)) {
                    input[row][column] = 1;
                    if (trackSquare(row + 1)) {
                        return true;
                    } else {
                        input[row][column] = 0;
                    }
                }
            }
            return false;
        }
    }

    private boolean checkSquare(int row, int column) {

        //check row and column
        for (int i = 0; i < queenCount; i++) {
            if (input[row][i] == 1 || input[i][column] == 1) {
                return false;
            }
        }

        //check leftup diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (input[i][j] == 1) {
                return false;
            }
        }

        //check rightup diagonal
        for (int i = row, j = column; i >= 0 && j < queenCount; i--, j++) {
            if (input[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
