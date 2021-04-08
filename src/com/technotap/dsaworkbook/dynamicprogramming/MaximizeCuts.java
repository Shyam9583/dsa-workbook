package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximizeCuts {
    private static final int INFINITY = Integer.MIN_VALUE >> 1;

    public static void main(String[] args) {
        int n = 7, x = 5, y = 5, z = 2;
        System.out.println(maximizeCuts(n, x, y, z));
    }

    private static int maximizeCuts(int n, int x, int y, int z) {
        int[] cuts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = INFINITY;
            if (x <= i) max = Math.max(max, 1 + cuts[i - x]);
            if (y <= i) max = Math.max(max, 1 + cuts[i - y]);
            if (z <= i) max = Math.max(max, 1 + cuts[i - z]);
            cuts[i] = (max == INFINITY) ? Integer.MIN_VALUE : max;
        }
        return Math.max(cuts[n], 0);
    }
}
