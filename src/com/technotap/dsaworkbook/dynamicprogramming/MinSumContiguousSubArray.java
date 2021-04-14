package com.technotap.dsaworkbook.dynamicprogramming;

public class MinSumContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {3, -4, 2, -3, -1, 7, -5};
        System.out.println(minSum(arr));
    }

    private static int minSum(int[] arr) {
        int minSoFar = Integer.MAX_VALUE, minTillNow = 0;
        for (int item : arr) {
            minTillNow += item;
            minSoFar = Math.min(minSoFar, minTillNow);
            minTillNow = Math.min(minTillNow, 0);
        }
        return minSoFar;
    }
}
