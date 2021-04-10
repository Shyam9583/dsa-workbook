package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestSubsequenceWithDifference1 {
    public static void main(String[] args) {
        int[] A = {10, 9, 4, 5, 4, 8, 6};
        System.out.println(longestSubsequence(A.length, A));
    }

    private static int longestSubsequence(int N, int[] A) {
        int[] dp = new int[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (Math.abs(A[i] - A[j]) == 1) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
