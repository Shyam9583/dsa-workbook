package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximumSumRectangle {
    public static void main(String[] args) {
        int[][] M = {{1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 10, 1, 3}, {-4, -1, 1, 7, -6}};
        System.out.println(maxSumRectangle(M.length, M[0].length, M));
    }

    private static int maxSumRectangle(int R, int C, int[][] M) {
        int maxSum = Integer.MIN_VALUE;
        for (int k = 0; k < R; k++) {
            int[] arr = new int[C];
            for (int i = k; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[j] += M[i][j];
                }
                maxSum = Math.max(maxSum, kadane(arr));
            }
        }
        return maxSum;
    }

    private static int kadane(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxTillNow = 0;
        for (int value : arr) {
            maxTillNow += value;
            maxSoFar = Math.max(maxSoFar, maxTillNow);
            maxTillNow = Math.max(maxTillNow, 0);
        }
        return maxSoFar;
    }
}
