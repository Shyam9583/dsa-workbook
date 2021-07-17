package com.technotap.dsaworkbook.array;

import java.util.Stack;

public class MaxAreaMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println(maxAreaInMatrix(matrix, matrix.length, matrix[0].length));
    }

    private static int maxArea(int[] hist) {
        // Max area of histograms
        int maxArea = Integer.MIN_VALUE;
        // Stack for keeping indices
        Stack<Integer> stack = new Stack<>();
        // Left[i] = left boundary of index i element
        // Right[i] = right boundary of index i element
        int[] left = new int[hist.length], right = new int[hist.length];
        // Loop to find right boundary
        for (int i = 0; i < hist.length; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (hist[top] > hist[i]) {
                    right[top] = i;
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }
        // Set right boundary of remaining indices
        while (!stack.isEmpty()) {
            right[stack.pop()] = hist.length;
        }
        // Loop to find left boundary
        for (int i = hist.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (hist[top] > hist[i]) {
                    left[top] = i;
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }
        // Set left boundary of remaining indices
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
        // max area = height * (right - left - 1) [*** range ***]
        for (int i = 0; i < hist.length; i++) {
            maxArea = Math.max(maxArea, hist[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }

    private static int maxAreaInMatrix(int[][] matrix, int n, int m) {
        // This will store the max result
        int maxArea = maxArea(matrix[0]);
        // Loop through each row
        for (int i = 1; i < n; i++) {
            // For each row, update the value to create histogram
            for (int j = 0; j < m; j++) {
                matrix[i][j] += matrix[i][j] * matrix[i - 1][j];
            }
            // Calculate the max area
            maxArea = Math.max(maxArea, maxArea(matrix[i]));
        }
        return maxArea;
    }
}
