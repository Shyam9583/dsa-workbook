package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        int[] nums = {5, 17, 17, 18, 16, 9, 9};
        System.out.println(LAS(nums));
    }

    private static int LAS(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) down = up + 1;
            if (nums[i] > nums[i - 1]) up = down + 1;
        }
        return Math.max(up, down);
    }
}
