package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;

public class FindKthElementIn2SortedArrays {
    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7, 9, 11};
        int[] B = {1, 2, 4, 8, 10};
        int k = 6;
        System.out.println(kthElementEfficient(A, B, k));
    }

    private static int kthElement(int[] A, int[] B, int n, int m, int k) {
        if (k > n + m)
            return Integer.MIN_VALUE;
        int i = 0, j = 0, pos = 1;
        while (i < n && j < m) {
            if (pos == k)
                return Math.min(A[i], B[j]);
            if (A[i] < B[j]) {
                i++;
                pos++;
            } else if (A[i] > B[j]) {
                j++;
                pos++;
            } else {
                i++;
                pos++;
            }
        }
        while (i < n) {
            if (pos == k)
                return A[i];
            i++;
        }
        while (j < m) {
            if (pos == k)
                return B[j];
            j++;
        }
        return Integer.MIN_VALUE;
    }

    private static int kthElementEfficient(int[] A, int[] B, int k) {
        if (A.length == 0 && B.length > 0) {
            return B[k - 1];
        }
        if (B.length == 0 && A.length > 0) {
            return A[k - 1];
        }
        if (k == 1) {
            return Math.min(A[0], B[0]);
        }
        int i = Math.min(A.length, k / 2);
        int j = Math.min(B.length, k / 2);
        if (A[i - 1] < B[j - 1]) {
            return kthElementEfficient(Arrays.copyOfRange(A, i, A.length), Arrays.copyOf(B, j), k - i);
        } else {
            return kthElementEfficient(Arrays.copyOf(A, i), Arrays.copyOfRange(B, j, B.length), k - j);
        }
    }

}
