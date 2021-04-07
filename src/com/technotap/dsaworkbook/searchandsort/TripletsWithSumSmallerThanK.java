package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;

public class TripletsWithSumSmallerThanK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7};
        int k = 12;
        System.out.println(count(arr, arr.length, k));
    }

    private static long count(int[] arr, int n, int sum) {
        long count = 0;
        if (n < 3)
            return count;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum >= sum) {
                    right--;
                } else {
                    count += (right - left);
                    left++;
                }
            }
        }
        return count;
    }
}
