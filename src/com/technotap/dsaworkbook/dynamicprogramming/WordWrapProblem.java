package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class WordWrapProblem {
    private static final int INFINITY = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 4, 3, 4, 1, 5, 8, 5};
        int k = 12;
        System.out.println(Arrays.deepToString(solveWrap(nums, k)));
    }

    private static int[][] solveWrap(int[] nums, int k) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i, gap = 0; j < N; j++, gap++) {
                int spaces = k - (sum[j + 1] - sum[i] + gap);
                if (spaces < 0) dp[i][j] = INFINITY;
                else dp[i][j] = spaces * spaces;
            }
        }
        int[] cost = new int[N + 1], arrange = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = N; j > i; j--) {
                int currCost = cost[j] + dp[i][j - 1];
                if (currCost < minCost) {
                    arrange[i] = j;
                    minCost = currCost;
                }
            }
            cost[i] = minCost;
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i = arrange[i]) {
            list.add(new int[]{i + 1, arrange[i]});
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
