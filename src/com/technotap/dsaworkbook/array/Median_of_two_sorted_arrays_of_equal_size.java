package com.technotap.dsaworkbook.array;

public class Median_of_two_sorted_arrays_of_equal_size {
    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38}, B = {2, 13, 17, 30, 45};
        System.out.println(medianOfArrays(A, B));
    }

    private static int medianOfArrays(int[] A, int[] B) {
        int n = A.length;
        return medianOfArraysUtil(A, B, 0, n - 1, 0, n - 1);
    }

    private static int medianOfArraysUtil(int[] A, int[] B, int startA, int endA, int startB, int endB) {
        int n = endA - startA + 1;
        if (n == 1) return (A[startA] + B[startB]) / 2;
        if (n == 2) return (Math.max(A[startA], B[startB]) + Math.min(A[endA], B[endB])) / 2;
        int m1 = median(A, startA, endA), m2 = median(B, startB, endB);
        if (m1 < m2) return medianOfArraysUtil(A, B, startA + n / 2, endA, startB, startB + n / 2);
        else return medianOfArraysUtil(A, B, startA, startA + n / 2, startB + n / 2, endB);
    }

    private static int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        return n % 2 == 0 ? (arr[start + n / 2] + arr[start + n / 2 - 1]) / 2 : arr[start + n / 2];
    }
}
