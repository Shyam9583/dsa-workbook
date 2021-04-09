package com.technotap.dsaworkbook.dynamicprogramming;

public class LCSOf3Strings {
    public static void main(String[] args) {
        String A = "geeks";
        String B = "geeksfor";
        String C = "geeksforgeeks";
        System.out.println(LCS(A, B, C, A.length(), B.length(), C.length()));
    }

    private static int LCS(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        int max = Integer.MIN_VALUE;
                        max = Math.max(max, dp[i - 1][j][k]);
                        max = Math.max(max, dp[i][j - 1][k]);
                        max = Math.max(max, dp[i][j][k - 1]);
                        max = Math.max(max, dp[i - 1][j - 1][k - 1]);
                        dp[i][j][k] = max;
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}
