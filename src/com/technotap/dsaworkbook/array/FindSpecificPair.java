package com.technotap.dsaworkbook.array;

public class FindSpecificPair {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 6, 1, 3},
                {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}
        };
        System.out.println("Maximum Difference : " + maxValue(matrix, matrix.length));
    }

    private static int maxValue(int[][] matrix, int n) {
        int[][] maxMatrix = new int[n][n];

        int maxVal = matrix[n - 1][n - 1];

        maxMatrix[n - 1][n - 1] = matrix[n - 1][n - 1];

        for (int j = n - 2; j >= 0; j--) {
            if (maxVal < matrix[n - 1][j])
                maxVal = matrix[n - 1][j];
            maxMatrix[n - 1][j] = maxVal;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (maxVal < matrix[i][n - 1])
                maxVal = matrix[i][n - 1];
            maxMatrix[i][n - 1] = maxVal;
        }

        maxVal = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (maxMatrix[i + 1][j + 1] - matrix[i][j] > maxVal)
                    maxVal = maxMatrix[i + 1][j + 1] - matrix[i][j];

                maxMatrix[i][j] = Math.max(
                        matrix[i][j],
                        Math.max(
                                maxMatrix[i][j + 1],
                                maxMatrix[i + 1][j])
                );
            }
        }

        return maxVal;
    }

}
