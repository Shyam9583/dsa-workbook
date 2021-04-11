package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;

public class MinimumCostToFillABag {
    private static final int INFINITY = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) {
        int[] cost = {16, 19, 6, 3, 12, 10};
        int W = 15;
        System.out.println(minCost(cost, cost.length, W));
    }

    private static int minCost(int[] cost, int N, int W) {
        int[] curr = new int[W + 1], prev = new int[W + 1], temp;
        int[] val = new int[N], wt = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            if (cost[i] == -1) continue;
            val[size] = cost[i];
            wt[size] = i + 1;
            size++;
        }
        N = size;
        Arrays.fill(curr, INFINITY);
        for (int i = 1; i <= N; i++) {
            temp = curr;
            curr = prev;
            prev = temp;
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) curr[j] = prev[j];
                else {
                    curr[j] = Math.min(prev[j], val[i - 1] + curr[j - wt[i - 1]]);
                }
            }
        }
        return curr[W] == INFINITY ? -1 : curr[W];
    }
}
