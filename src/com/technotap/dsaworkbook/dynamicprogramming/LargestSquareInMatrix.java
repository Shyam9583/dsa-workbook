package com.technotap.dsaworkbook.dynamicprogramming;

public class LargestSquareInMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 0}
        };
        System.out.println(maxSquare(mat.length, mat[0].length, mat));
    }

    private static int maxSquare(int n, int m, int[][] mat) {
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (mat[i][j - 1] == 0) {
                    dp[j] = 0;
                } else {
                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                }
                max = Math.max(max, dp[j]);
                prev = temp;
            }
        }
        return max;
    }
}
