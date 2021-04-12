package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String S1 = "ABCDGH", S2 = "ACDGHR";
        System.out.println(LCS(S1, S2, S1.length(), S2.length()));
    }

    private static int LCS(String S1, String S2, int n, int m) {
        int[] dp = new int[m + 1];
        int result = 0, temp, prev;
        for (int i = 1; i <= n; i++) {
            prev = 0;
            for (int j = 1; j <= m; j++) {
                temp = dp[j];
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                    result = Math.max(result, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return result;
    }
}
