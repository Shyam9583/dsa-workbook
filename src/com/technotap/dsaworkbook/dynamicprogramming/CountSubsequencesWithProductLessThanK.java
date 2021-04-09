package com.technotap.dsaworkbook.dynamicprogramming;

public class CountSubsequencesWithProductLessThanK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 10;
        System.out.println(count(arr, arr.length, k));
    }

    private static int count(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int prod = 1; prod <= k; prod++) {
            for (int i = 1; i <= n; i++) {
                dp[prod][i] = dp[prod][i - 1];
                if (arr[i - 1] <= prod && arr[i - 1] > 0) {
                    dp[prod][i] += dp[prod / arr[i - 1]][i - 1] + 1;
                }
            }
        }
        return dp[k][n];
    }
}
