package com.technotap.dsaworkbook.dynamicprogramming;

public class MaxProfitWith2Trades {
    public static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(prices.length, prices));
    }

    private static int maxProfit(int n, int[] prices) {
        int[] dp = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            dp[i] = Math.max(dp[i + 1], max - prices[i]);
        }
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], dp[i] + prices[i] - min);
        }
        return dp[n - 1];
    }
}
