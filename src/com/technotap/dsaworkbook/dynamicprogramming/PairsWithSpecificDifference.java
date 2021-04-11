package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;

public class PairsWithSpecificDifference {
    public static void main(String[] args) {
        int[] arr = {3, 6, 19, 16, 15, 25, 26, 25, 7};
        int K = 4;
        System.out.println(maxSum(arr, arr.length, K));
    }

    private static int maxSum(int[] arr, int N, int K) {
        Arrays.sort(arr);
        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] < K) {
                dp[i] = dp[Math.max(i - 2, 0)] + arr[i] + arr[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[N - 1];
    }
}
