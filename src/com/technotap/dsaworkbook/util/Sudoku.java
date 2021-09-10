package com.technotap.dsaworkbook.util;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        System.out.println(solve(board));
    }

    private static boolean solve(int[][] board) {
        int[] rowCheck = new int[board.length], colCheck = new int[board.length];
        int[][] gridCheck = new int[board.length / 3][board.length / 3];
        boolean[] isSolved = {false};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) continue;
                int val = 1 << board[i][j];
                rowCheck[i] |= val;
                colCheck[j] |= val;
                gridCheck[i / 3][j / 3] |= val;
            }
        }

        solveRec(0, 0, board, rowCheck, colCheck, gridCheck, isSolved);

        return isSolved[0];
    }

    private static void solveRec(int i, int j, int[][] board, int[] rowCheck, int[] colCheck, int[][] gridCheck, boolean[] isSolved) {
        if (isSolved[0]) return;

        if (i == board.length) {
            isSolved[0] = true;
            printBoard(board);
            return;
        }

        int nextI, nextJ;
        if (j == board.length - 1) {
            nextI = i + 1;
            nextJ = 0;
        } else {
            nextI = i;
            nextJ = j + 1;
        }

        if (board[i][j] != 0) {
            solveRec(nextI, nextJ, board, rowCheck, colCheck, gridCheck, isSolved);
            return;
        }

        for (int number = 1; number < 10; number++) {
            int val = 1 << number;
            if (((rowCheck[i] & val) == 0) && ((colCheck[j] & val) == 0) && ((gridCheck[i / 3][j / 3] & val) == 0)) {
                board[i][j] = number;
                rowCheck[i] ^= val;
                colCheck[j] ^= val;
                gridCheck[i / 3][j / 3] ^= val;
                solveRec(nextI, nextJ, board, rowCheck, colCheck, gridCheck, isSolved);
                board[i][j] = 0;
                rowCheck[i] ^= val;
                colCheck[j] ^= val;
                gridCheck[i / 3][j / 3] ^= val;
            }
        }
    }

    private static void printBoard(int[][] board) {
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
