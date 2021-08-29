package com.technotap.dsaworkbook.dynamicprogramming;

public class BurstBalloon {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    private static int maxCoins(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        for (int g = 0; g < N; g++) {
            for (int i = 0, j = g; j < N; i++, j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int middle = nums[k] * (i - 1 < 0 ? 1 : nums[i - 1]) * (j + 1 < N ? nums[j + 1] : 1);
                    dp[i][j] = Math.max(dp[i][j], left + middle + right);
                }
            }
        }
        return dp[0][N - 1];
    }
}
