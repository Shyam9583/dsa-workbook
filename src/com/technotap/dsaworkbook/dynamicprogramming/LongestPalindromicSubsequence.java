package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "BBABCBCAB";
        System.out.println(LPS(s));
    }

    private static int LPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i + 1][j], dp[i + 1][j - 1]));
                }
            }
        }
        return dp[0][n - 1];
    }
}
