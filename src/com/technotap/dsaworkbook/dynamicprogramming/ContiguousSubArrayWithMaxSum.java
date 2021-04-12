package com.technotap.dsaworkbook.dynamicprogramming;

public class ContiguousSubArrayWithMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSubArraySum(arr));
    }

    private static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxTillNow = 0;
        for (int val : arr) {
            maxTillNow += val;
            maxSoFar = Math.max(maxSoFar, maxTillNow);
            if (maxTillNow < 0) maxTillNow = 0;
        }
        return maxSoFar;
    }
}
