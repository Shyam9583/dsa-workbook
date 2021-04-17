package com.technotap.dsaworkbook.dynamicprogramming;

public class OptimalBST {
    public static void main(String[] args) {
        int[] freq = {3, 1, 2, 1};
        System.out.println(optimalCost(freq.length, freq));
    }

    private static long optimalCost(int n, int[] freq) {
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = freq[i - 1] + sum[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) dp[i][j] = freq[i];
                else if (g == 1) {
                    dp[i][j] = Math.min(
                            freq[i] + 2 * freq[j],
                            freq[j] + 2 * freq[i]);
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        int left = (k == i) ? 0 : dp[i][k - 1];
                        int down = (k == j) ? 0 : dp[k + 1][j];
                        min = Math.min(min, left + down);
                    }
                    dp[i][j] = min + sum[j + 1] - sum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
