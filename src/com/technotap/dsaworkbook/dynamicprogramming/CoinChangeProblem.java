package com.technotap.dsaworkbook.dynamicprogramming;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int n = 4, m = 3;
        int[] S = {1, 2, 3};
        System.out.println(count(S, m, n));
        System.out.println(countPermutations(S, m, n));
    }

    private static long count(int[] S, int m, int n) {
        long[] target = new long[n + 1];
        target[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = S[i]; j <= n; j++) {
                target[j] += target[j - S[i]];
            }
        }
        return target[n];
    }

    private static long countPermutations(int[] S, int m, int n) {
        long[] target = new long[n + 1];
        target[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s : S) {
                if (i - s < 0) continue;
                target[i] += target[i - s];
            }
        }
        return target[n];
    }
}
