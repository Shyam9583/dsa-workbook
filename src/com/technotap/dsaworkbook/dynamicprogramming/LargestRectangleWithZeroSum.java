package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class LargestRectangleWithZeroSum {
    public static void main(String[] args) {
        int[][] matrix = {{9, 7, 16, 5}, {1, -6, -7, 3},
                {1, 8, 7, 9}, {7, -2, 0, 10}};
        System.out.println(Arrays.deepToString(largestRectangle(matrix, matrix.length, matrix[0].length)));
    }

    private static int[][] largestRectangle(int[][] matrix, int R, int C) {
        int startI = 0, startJ = 0, r = R, c = C, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < R; k++) {
            int[] arr = new int[C];
            for (int i = k; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[j] += matrix[i][j];
                }
                Pair pair = maxWidth(arr, map);
                int currR = (i - k + 1), currC = (pair.end - pair.start + 1);
                if (max < currR * currC) {
                    max = currR * currC;
                    startI = k;
                    startJ = pair.start;
                    r = currR;
                    c = currC;
                }
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            if (c >= 0) System.arraycopy(matrix[startI + i], startJ, result[i], 0, c);
        }
        return result;
    }

    private static Pair maxWidth(int[] arr, HashMap<Integer, Integer> map) {
        int maxLength = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLength == 0) {
                maxLength = 1;
                start = end = i;
            }
            if (sum == 0) {
                if (maxLength < i + 1) {
                    start = 0;
                    end = i;
                }
                maxLength = i + 1;
            }
            Integer prev = map.get(sum);
            if (prev != null) {
                int old = maxLength;
                maxLength = Math.max(old, i - prev);
                if (old < maxLength) {
                    start = prev + 1;
                    end = i;
                }
            } else map.put(sum, i);
        }
        map.clear();
        return new Pair(start, end);
    }

    private static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
