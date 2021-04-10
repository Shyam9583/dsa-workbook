package com.technotap.dsaworkbook.dynamicprogramming;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.println(eggDrop(n, k));
    }

    private static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < j; l++) {
                    min = Math.min(min, Math.max(dp[i - 1][l], dp[i][j - l - 1]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }
}
