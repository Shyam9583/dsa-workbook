package com.technotap.dsaworkbook.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] pairs = new int[input.length / 2][2];
        for (int i = 0, j = 0; i < input.length; i = i + 2) {
            pairs[j++] = new int[]{input[i], input[i + 1]};
        }
        Pair[] arr = new Pair[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            arr[i] = new Pair(pairs[i][0], pairs[i][1]);
        }
        System.out.println(maxChainLength(arr, arr.length));
    }

    private static int maxChainLength(Pair[] arr, int n) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o.x));
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
