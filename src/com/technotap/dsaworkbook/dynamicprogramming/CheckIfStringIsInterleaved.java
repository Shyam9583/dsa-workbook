package com.technotap.dsaworkbook.dynamicprogramming;

public class CheckIfStringIsInterleaved {
    public static void main(String[] args) {
        String A = "XY", B = "X", C = "XX";
        System.out.println(isInterleaved(A, B, C));
    }

    private static boolean isInterleaved(String a, String b, String c) {
        int n = a.length(), m = b.length(), len = c.length();
        if (len != n + m) return false;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return isInterleavedRec(a, b, c, n, m, len, dp) == 1;
    }

    private static int isInterleavedRec(String a, String b, String c, int n, int m, int len, int[][] dp) {
        if (len == 0) return 1;
        if (dp[n][m] != -1) return dp[n][m];
        int result = 0;
        if (n > 0 && a.charAt(n) == c.charAt(len)) {
            result |= isInterleavedRec(a, b, c, n - 1, m, len - 1, dp);
        }
        if (m > 0 && b.charAt(m) == c.charAt(len)) {
            result |= isInterleavedRec(a, b, c, n, m - 1, len - 1, dp);
        }
        dp[n][m] = result;
        return dp[n][m];
    }
}
