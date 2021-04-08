package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "axxxy";
        System.out.println(LRS(str));
    }

    private static int LRS(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if ((i != j - 1) && (str.charAt(i) == str.charAt(j - 1))) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(prev, Math.max(dp[j], dp[j - 1]));
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}
