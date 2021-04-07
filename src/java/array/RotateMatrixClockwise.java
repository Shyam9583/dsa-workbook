package java.array;

import java.util.Arrays;

public class RotateMatrixClockwise {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        try {
            rotateAntiClockwise(matrix, matrix.length, matrix[0].length);
            for (int[] row : matrix) System.out.println(Arrays.toString(row));
        } catch (NotSquareMatrixException e) {
            e.printStackTrace();
        }
    }

    private static void rotateClockwise(int[][] matrix, int m, int n) throws NotSquareMatrixException {
        if (m != n)
            throw new NotSquareMatrixException();
        int temp;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < (n - i - 1); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    private static void rotateAntiClockwise(int[][] matrix, int m, int n) throws NotSquareMatrixException {
        if (m != n)
            throw new NotSquareMatrixException();
        int temp;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < (n - i - 1); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }

    private static class NotSquareMatrixException extends Exception {
        NotSquareMatrixException() {
            super("The matrix is not square. It can't be rotated.");
        }
    }
}
