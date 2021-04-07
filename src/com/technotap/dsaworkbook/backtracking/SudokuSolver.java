package com.technotap.dsaworkbook.backtracking;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1,},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (!solveSudoku(grid)) System.out.println("Invalid board");
    }

    private static boolean solveSudoku(int[][] grid) {
        boolean result = solveSudokuRecur(grid, 0, 0);
        if (result) printGrid(grid);
        return result;
    }

    private static boolean solveSudokuRecur(int[][] grid, int i, int j) {
        if (i == grid.length) return true;
        int ni, nj;
        if (j == grid[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (grid[i][j] != 0) {
            return solveSudokuRecur(grid, ni, nj);
        } else {
            for (int po = 1; po < 10; po++) {
                if (isValid(grid, i, j, po)) {
                    grid[i][j] = po;
                    if (solveSudokuRecur(grid, ni, nj)) return true;
                    grid[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int row, int col, int val) {
        for (int j = 0; j < grid.length; j++) {
            if (grid[row][j] == val) return false;
        }
        for (int[] ints : grid) {
            if (ints[col] == val) return false;
        }
        int smi = row / 3 * 3, smj = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[smi + i][smj + j] == val) return false;
            }
        }
        return true;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int digit : row) {
                System.out.print(digit + " ");
            }
        }
    }

}
