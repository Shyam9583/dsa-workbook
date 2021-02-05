package array;

import java.util.EmptyStackException;
import java.util.Stack;

public class MaxAreaRectangle {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println("Max Area : " + maxArea(matrix, matrix.length, matrix[0].length));
    }

    private static int maxArea(int[][] M, int m, int n) {
        int max = Integer.MIN_VALUE;
        int currentTop = 0;
        int[] current = new int[n];
        for (int i = 0; i < m; i++) {
            for (int el : M[i]) {
                current[currentTop] = (el == 1) ? current[currentTop] + 1 : 0;
                currentTop++;
            }
            int area = maxAreaRectangle(current, n);
            if (area > max)
                max = area;
            currentTop = 0;
        }
        return max;
    }

    private static int maxAreaRectangle(int[] bars, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            try {
                if (bars[stack.peek()] >= bars[i]) {
                    while (bars[stack.peek()] >= bars[i]) {
                        stack.pop();
                    }
                }
                left[i] = stack.peek() + 1;
                stack.push(i);
            } catch (EmptyStackException e) {
                left[i] = 0;
                stack.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            try {
                int top = stack.peek();
                if (top >= 0 && top < n) {
                    if (bars[stack.peek()] >= bars[i]) {
                        while (bars[stack.peek()] >= bars[i]) {
                            stack.pop();
                        }
                    }
                }
                right[i] = stack.peek() - 1;
                stack.push(i);
            } catch (EmptyStackException e) {
                right[i] = n - 1;
                stack.push(i);
            }
        }
        for (int i = 0; i < n; i++) {
            int area = (right[i] - left[i] + 1) * bars[i];
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
