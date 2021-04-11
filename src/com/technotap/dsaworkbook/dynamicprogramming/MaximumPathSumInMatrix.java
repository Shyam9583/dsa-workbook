package com.technotap.dsaworkbook.dynamicprogramming;

public class MaximumPathSumInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{348, 391},
                {618, 193}};
        System.out.println(maxPath(matrix.length, matrix));
    }

    private static int maxPath(int N, int[][] Matrix) {
        int[] curr = new int[N], next = new int[N], temp;
        if (N >= 0) System.arraycopy(Matrix[N - 1], 0, curr, 0, N);
        for (int i = N - 2; i >= 0; i--) {
            temp = curr;
            curr = next;
            next = temp;
            for (int j = 0; j < N; j++) {
                int max = next[j];
                if (j - 1 >= 0) max = Math.max(max, next[j - 1]);
                if (j + 1 < N) max = Math.max(max, next[j + 1]);
                curr[j] = Matrix[i][j] + max;
            }
        }
        int result = 0;
        for (int val : curr) result = Math.max(result, val);
        return result;
    }
}
