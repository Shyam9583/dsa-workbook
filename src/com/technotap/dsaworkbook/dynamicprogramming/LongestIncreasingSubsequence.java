package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(LIS(a.length, a));
    }

    private static int LIS(int n, int[] a) {
        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int item : a) {
            int pos = upperBound(dp, item);
            dp[pos] = item;
        }
        for (int i = a.length; i > 0; i--) {
            if (dp[i] != Integer.MAX_VALUE) return i;
        }
        return 1;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
