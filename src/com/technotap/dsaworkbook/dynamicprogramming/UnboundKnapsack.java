package com.technotap.dsaworkbook.dynamicprogramming;

public class UnboundKnapsack {
    public static void main(String[] args) {
        int[] val = {1, 1};
        int[] wt = {2, 1};
        int N = val.length, W = 3;
        System.out.println(knapsack(N, W, val, wt));
    }

    private static int knapsack(int N, int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        return dp[W];
    }
}
