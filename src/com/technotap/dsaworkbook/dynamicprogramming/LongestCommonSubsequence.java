package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(LCS(s1.length(), s2.length(), s1, s2));
    }

    private static int LCS(int p, int q, String s1, String s2) {
        int[] dp = new int[q + 1];
        for (int i = 0; i < p; i++) {
            int prev = 0;
            for (int j = 1; j <= q; j++) {
                int temp = dp[j];
                if (s1.charAt(i) == s2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(prev, Math.max(dp[j], dp[j - 1]));
                }
                prev = temp;
            }
        }
        return dp[q];
    }
}
