package com.technotap.dsaworkbook.dynamicprogramming;

public class CountBalancedBinaryTree {
    private static final long MAX = (long) (1e9 + 7);

    public static void main(String[] args) {
        int h = 3;
        System.out.println(count(h));
    }

    private static long count(int h) {
        if (h < 2) return 1;
        long first = 1, second = 1;
        for (int i = 2; i <= h; i++) {
            long curr = (2 * (first * second) + (second * second)) % MAX;
            first = second;
            second = curr;
        }
        return second;
    }
}
