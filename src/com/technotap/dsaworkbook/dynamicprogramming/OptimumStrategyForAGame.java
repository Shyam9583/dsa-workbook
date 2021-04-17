package com.technotap.dsaworkbook.dynamicprogramming;

public class OptimumStrategyForAGame {
    public static void main(String[] args) {
        int[] arr = {8, 15, 3, 7};
        System.out.println(countMaximum(arr, arr.length));
    }

    private static long countMaximum(int[] arr, int n) {
        long[][] dp = new long[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) dp[i][j] = arr[i];
                else if (g == 1) dp[i][j] = Math.max(arr[i], arr[j]);
                else {
                    long ith = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    long jth = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(ith, jth);
                }
            }
        }
        return dp[0][n - 1];
    }
}
