package com.technotap.dsaworkbook.array;

import java.util.Arrays;

public class SortArrayWithoutSorting {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a, int n) {
        int[] count = new int[3];
        for (int val : a) {
            count[val]++;
        }
        for (int i = 0, ptr = 0; i < n; ++ptr) {
            while (count[ptr]-- > 0) a[i++] = ptr;
        }
    }
}
