package com.technotap.dsaworkbook.util;

import java.util.Arrays;

public class EnhancedMergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 3, 4, 5, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    private static void merge(int[] arr, int start, int end) {
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                int j = i + gap;
                if (arr[i] > arr[j]) swap(arr, i, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
}
