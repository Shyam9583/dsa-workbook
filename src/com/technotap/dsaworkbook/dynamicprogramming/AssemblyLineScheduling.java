package com.technotap.dsaworkbook.dynamicprogramming;

public class AssemblyLineScheduling {
    public static void main(String[] args) {
        int[][] a = {{4, 5, 3, 2}, {2, 10, 1, 4}};
        int[][] t = {{0, 7, 4, 5}, {0, 9, 2, 8}};
        int[] e = {10, 12}, x = {18, 7};
        System.out.println(minTime(a, t, e, x));
    }

    private static int minTime(int[][] a, int[][] t, int[] e, int[] x) {
        int first = e[0] + a[0][0], second = e[1] + a[1][0];
        for (int j = 1; j < a[0].length; j++) {
            int up = Math.min(first + a[0][j], second + a[0][j] + t[1][j]);
            int down = Math.min(second + a[1][j], first + a[1][j] + t[0][j]);
            first = up;
            second = down;
        }
        return Math.min(first + x[0], second + x[1]);
    }
}
