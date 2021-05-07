package com.technotap.dsaworkbook.bitmanipulation;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(board);
    }

    private static void solve(int[][] board) {
        int n = board.length, m = board[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        int[][] grid = new int[n / 3][m / 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                int val = 1 << board[i][j];
                row[i] |= val;
                col[j] |= val;
                grid[i / 3][j / 3] |= val;
            }
        }
        solveRec(board, row, col, grid, 0, 0);
    }

    private static void solveRec(int[][] board, int[] row, int[] col, int[][] grid, int i, int j) {
        if (i == board.length) {
            print(board);
            return;
        }
        int nextI = (j == board[0].length - 1) ? i + 1 : i;
        int nextJ = (j == board[0].length - 1) ? 0 : j + 1;
        if (board[i][j] != 0) {
            solveRec(board, row, col, grid, nextI, nextJ);
            return;
        }
        for (int num = 1; num < 10; num++) {
            int val = 1 << num;
            if (((row[i] & val) == 0) && ((col[j] & val) == 0) && ((grid[i / 3][j / 3] & val) == 0)) {
                board[i][j] = num;
                row[i] ^= val;
                col[j] ^= val;
                grid[i / 3][j / 3] ^= val;
                solveRec(board, row, col, grid, nextI, nextJ);
                board[i][j] = 0;
                row[i] ^= val;
                col[j] ^= val;
                grid[i / 3][j / 3] ^= val;
            }
        }
    }

    private static void print(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
