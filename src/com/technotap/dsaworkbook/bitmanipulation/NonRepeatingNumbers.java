package com.technotap.dsaworkbook.bitmanipulation;

import java.util.Arrays;

public class NonRepeatingNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    private static int[] singleNumber(int[] nums) {
        int xXORy = 0;
        int x = 0, y = 0;

        for (int val : nums) xXORy ^= val;

        int lsb = xXORy & -xXORy;

        for (int val : nums) {
            if ((lsb & val) == 0) x ^= val;
            else y ^= val;
        }
        return x < y ? new int[]{x, y} : new int[]{y, x};
    }
}
