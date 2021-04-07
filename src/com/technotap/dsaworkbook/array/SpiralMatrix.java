package com.technotap.dsaworkbook.array;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printInSpiral(matrix, matrix.length, matrix[0].length);
    }

    private static void printInSpiral(int[][] matrix, int N, int M) {
        int top = 0, down = N - 1, left = 0, right = M - 1;
        int direction = 0;
        while (top <= down && left <= right) {
            switch (direction) {
                case 0: {
                    for (int i = left; i <= right; i++) {
                        System.out.print(matrix[top][i] + " ");
                    }
                    top += 1;
                    break;
                }
                case 1: {
                    for (int i = top; i <= down; i++) {
                        System.out.print(matrix[i][right] + " ");
                    }
                    right -= 1;
                    break;
                }
                case 2: {
                    for (int i = right; i >= left; i--) {
                        System.out.print(matrix[down][i] + " ");
                    }
                    down -= 1;
                    break;
                }
                case 3: {
                    for (int i = down; i >= top; i--) {
                        System.out.print(matrix[i][left] + " ");
                    }
                    left += 1;
                }
                default:
                    break;
            }
            direction = (direction + 1) % 4;
        }
    }
}
