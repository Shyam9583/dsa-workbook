package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr, arr.length));
    }

    private static int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + arr[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
