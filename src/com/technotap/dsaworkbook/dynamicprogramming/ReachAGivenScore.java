package com.technotap.dsaworkbook.dynamicprogramming;

public class ReachAGivenScore {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(count(n));
    }

    private static long count(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        compute(dp, 3);
        compute(dp, 5);
        compute(dp, 10);
        return dp[n];
    }

    private static void compute(long[] dp, int value) {
        for (int i = 1; i < dp.length; i++) {
            if (i < value) continue;
            dp[i] += dp[i - value];
        }
    }
}
