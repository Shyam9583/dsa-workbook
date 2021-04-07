package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;

public class MinimizeSumOfDifferenceOf2Arrays {

    public static void main(String[] args) {
        long[] a = {4, 1, 8, 7};
        long[] b = {2, 3, 6, 5};
        System.out.println(minimize(a, b, a.length));
    }

    private static long minimize(long[] a, long[] b, int n) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(a[i] - b[i]);
        }
        return result;
    }

}
