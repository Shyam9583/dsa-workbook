package com.technotap.dsaworkbook.backtracking;

public class TraverseLandMine {

    private static final int INVALID = -1;
    private static final int[] moveRow = {0, 1, -1, 0};
    private static final int[] moveCol = {1, 0, 0, -1};
    private static int min;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1}};
        System.out.println(minPathLength(mat, mat.length, mat[0].length));
    }

    private static int minPathLength(int[][] mat, int nRows, int nCols) {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (mat[i][j] == 0) markInvalid(mat, nRows, nCols, i, j);
            }
        }
        for (int i = 0; i < nRows; i++) {
            traverseUtil(mat, nRows, nCols, i, 0, 0);
        }
        return min;
    }

    private static void traverseUtil(int[][] mat, int nRows, int nCols, int row, int col, int len) {
        if (!isValid(mat, nRows, nCols, row, col)) return;
        if (col == nCols - 1) {
            min = Math.min(min, len);
            return;
        }
        for (int i = 0; i < 3; i++) {
            mat[row][col] = -2;
            traverseUtil(mat, nRows, nCols, row + moveRow[i], col + moveCol[i], len + 1);
            mat[row][col] = 1;
        }
    }

    private static boolean isValid(int[][] mat, int nRows, int nCols, int row, int col) {
        return row > -1 && row < nRows && col > -1 && col < nCols && mat[row][col] > 0;
    }

    private static void markInvalid(int[][] mat, int nRows, int nCols, int row, int col) {
        if (row - 1 > -1) mat[row - 1][col] = INVALID;
        if (row + 1 < nRows) mat[row + 1][col] = INVALID;
        if (col - 1 > -1) mat[row][col - 1] = INVALID;
        if (col + 1 < nCols) mat[row][col + 1] = INVALID;
    }

}
