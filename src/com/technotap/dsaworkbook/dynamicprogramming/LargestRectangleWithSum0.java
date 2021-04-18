package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class LargestRectangleWithSum0 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {-3, -2, -1},
                {1, 7, 5}
        };
        System.out.println(Arrays.deepToString(largestRectangle(matrix, matrix.length, matrix[0].length)));
    }

    private static int[][] largestRectangle(int[][] matrix, int R, int C) {
        int startI = 0, startJ = 0, r = R, c = C, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < R; k++) {
            int[] copy = new int[C];
            for (int i = k; i < R; i++) {
                int sum = 0, maxDiff = 0;
                for (int j = 0; j < C; j++) {
                    copy[j] += matrix[i][j];
                    sum += copy[j];
                    if (map.containsKey(sum)) {
                        maxDiff = Math.max(maxDiff, j - map.get(sum));
                        if (max < (i + 1) * (j + 1)) {
                            max = (i + 1) * (j + 1);
                            startI = k;
                            startJ = map.get(sum) + 1;
                            r = i;
                            c = maxDiff;
                        }
                    } else {
                        map.put(sum, j);
                    }
                }
                map.clear();
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            if (c >= 0) System.arraycopy(matrix[startI + i], startJ, result[i], 0, c);
        }
        return result;
    }
}
