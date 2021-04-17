package com.technotap.dsaworkbook.dynamicprogramming;

public class CoinGameWinner {
    public static void main(String[] args) {
        int n = 5, x = 3, y = 4;
        System.out.println(findWinner(n, x, y));
    }

    private static boolean findWinner(int n, int x, int y) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            dp[i] = (i - 1 >= 0 && !dp[i - 1]) ||
                    (i - x >= 0 && !dp[i - x]) ||
                    (i - y >= 0 && !dp[i - y]);
        }
        return dp[n];
    }
}
