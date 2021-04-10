package com.technotap.dsaworkbook.dynamicprogramming;

public class MaxLengthChain {
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        Pair[] arr = new Pair[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            arr[i] = new Pair(pairs[i][0], pairs[i][1]);
        }
        System.out.println(maxChainLength(arr, arr.length));
    }

    private static int maxChainLength(Pair[] arr, int n) {
        int[] dp = new int[n];
        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].y < arr[i].x) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
