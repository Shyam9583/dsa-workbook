package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximumProfitUsingKTransactions {
    public static void main(String[] args) {
        int[] A = {10, 22, 5, 75, 65, 80};
        int K = 3;
        System.out.println(maxProfit(K, A.length, A));
    }

    private static int maxProfit(int K, int N, int[] A) {
        int[][] dp = new int[K + 1][N];
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j < N; j++) {
                int maxProfit = dp[i][j - 1];
                for (int k = 0; k < j; k++) {
                    maxProfit = Math.max(maxProfit, dp[i - 1][k] + A[j] - A[k]);
                }
                dp[i][j] = maxProfit;
            }
        }
        return dp[K][N - 1];
    }
}
