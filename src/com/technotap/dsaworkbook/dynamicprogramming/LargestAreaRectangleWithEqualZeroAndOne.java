package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LargestAreaRectangleWithEqualZeroAndOne {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 1}};
        System.out.println(largestArea(matrix.length, matrix[0].length, matrix));
    }

    private static int largestArea(int R, int C, int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < R; k++) {
            int[] arr = new int[C];
            for (int i = k; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[j] += (matrix[i][j] == 1) ? 1 : -1;
                }
                int c = maxLen(arr, arr.length, map);
                int r = i - k + 1;
                maxArea = Math.max(maxArea, r * c);
            }
        }
        return maxArea;
    }

    private static int maxLen(int[] arr, int n, Map<Integer, Integer> map) {
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else map.put(sum, i);
        }
        map.clear();
        return maxLen;
    }
}
