package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestChainPair {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        System.out.println(findLongestChain(pairs));
    }

    private static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
