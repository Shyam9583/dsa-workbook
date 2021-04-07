package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;

public class MaximizeSumAfterNegation {

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5};
        System.out.println(maximizeSum(arr, arr.length, 5));
    }

    private static long maximizeSum(long[] arr, int n, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && k > 0) {
                arr[i] = -arr[i];
                k--;
            }
        }
        if (k > 0 && (k & 1) == 1) {
            int minPosition = minPosition(arr);
            arr[minPosition] = -arr[minPosition];
        }
        return Arrays.stream(arr).sum();
    }

    private static int minPosition(long[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[minIndex] > arr[i])
                minIndex = i;
        }
        return minIndex;
    }

}
