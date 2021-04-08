package com.technotap.dsaworkbook.dynamicprogramming;

public class PaintingFence {
    private static final long M = (long) (1e9 + 7);

    public static void main(String[] args) {
        int n = 5, k = 3;
        System.out.println(countWays(n, k));
    }

    private static long countWays(int n, int k) {
        if (n < 2 || k < 2) return 1;
        long same = k, diff = (long) k * (k - 1), total = same + diff;
        for (int i = 2; i < n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }
}
