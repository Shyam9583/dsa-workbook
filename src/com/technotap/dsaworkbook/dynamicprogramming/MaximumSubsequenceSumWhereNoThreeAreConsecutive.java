package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximumSubsequenceSumWhereNoThreeAreConsecutive {
    public static void main(String[] args) {
        int[] arr = {100, 1000, 100, 1000, 1};
        System.out.println(maxSum(arr.length, arr));
    }

    private static int maxSum(int n, int[] arr) {
        int[] sum = new int[n];
        sum[0] = arr[0];
        sum[1] = arr[0] + arr[1];
        for (int i = 2; i < n; i++) {
            int max = sum[i - 1];
            max = Math.max(max, sum[i - 2] + arr[i]);
            if (i - 3 >= 0) max = Math.max(max, sum[i - 3] + arr[i - 1] + arr[i]);
            sum[i] = max;
        }
        return sum[n - 1];
    }
}
