package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;

public class MinimumRemovalToMakeDiffLessThanK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 9, 10, 11, 12, 17, 20};
        int k = 4;
        System.out.println(minRemoval(arr, arr.length, k));
    }

    private static int minRemoval(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = search(arr, i + 1, n - 1, arr[i], k);
            min = Math.min(min, n - (j - i + 1));
        }
        return min;
    }

    private static int search(int[] arr, int low, int high, int key, int k) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - key > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
