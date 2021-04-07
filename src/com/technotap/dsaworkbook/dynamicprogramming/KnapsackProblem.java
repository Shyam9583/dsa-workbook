package com.technotap.dsaworkbook.dynamicprogramming;

public class KnapsackProblem {
    public static void main(String[] args) {
        int n = 3, W = 4;
        int[] wt = {4, 5, 1}, val = {1, 2, 3};
        System.out.println(knapsack(W, wt, val, n));
    }

    private static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[n][W];
    }
}
