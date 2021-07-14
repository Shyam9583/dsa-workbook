package com.technotap.dsaworkbook.array;

public class Median_in_row_sorted_matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(median(matrix, matrix.length, matrix[0].length));
    }

    private static int median(int[][] matrix, int R, int C) {
        int desired = (R * C) / 2;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int[] arr : matrix) {
            low = Math.min(low, arr[0]);
            high = Math.max(high, arr[arr.length - 1]);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int[] arr : matrix) {
                count += upperbound(arr, mid);
            }
            if (count < desired) {
                low = mid + 1;
            } else high = mid;
        }
        return low;
    }

    private static int upperbound(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
