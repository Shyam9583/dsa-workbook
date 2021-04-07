package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;

public class BetterQuickSort {
    public static void main(String[] args) {
        int[] arr = {56, 2, 45};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        if (pos1 != pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            Partition p = partition(arr, start, end);
            sort(arr, start, p.left - 1);
            sort(arr, p.right + 1, end);
        }
    }

    private static Partition partition(int[] arr, int start, int end) {
        int current = start, lt = start, gt = end;
        int key = arr[start];
        while (current <= gt) {
            switch (Integer.compare(arr[current], key)) {
                case -1:
                    swap(arr, lt++, current++);
                    break;
                case 1:
                    swap(arr, gt--, current++);
                    break;
                case 0:
                    current++;
                    break;
            }
        }
        return new Partition(lt, gt);
    }

    private static class Partition {
        int left, right;

        public Partition(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
