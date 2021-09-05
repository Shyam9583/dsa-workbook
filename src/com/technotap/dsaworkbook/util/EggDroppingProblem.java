package com.technotap.dsaworkbook.util;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int k = 2, n = 6;
        System.out.println(superEggDrop(k, n));
    }

    private static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) dp[i][1] = 1;
        for (int j = 1; j <= n; j++) dp[1][j] = j;

        for (int e = 2; e <= k; e++) {
            for (int f = 2; f <= n; f++) {
                dp[e][f] = Integer.MAX_VALUE;
                for (int m = 1; m < f; m++) {
                    dp[e][f] = Math.min(dp[e][f], Math.max(dp[e - 1][m - 1], dp[e][f - m]));
                }
                dp[e][f] += 1;
            }
        }

        return dp[k][n];
    }
}
