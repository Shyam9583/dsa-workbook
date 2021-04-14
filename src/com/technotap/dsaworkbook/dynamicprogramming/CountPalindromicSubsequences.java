package com.technotap.dsaworkbook.dynamicprogramming;

public class CountPalindromicSubsequences {
    private static final long MAX = (long) (1e9 + 7);

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(countPS(str));
    }

    private static long countPS(String str) {
        int n = str.length();
        long[][] dp = new long[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] + 1) % MAX;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]) % MAX;
                }
            }
        }
        return dp[0][n - 1];
    }
}
