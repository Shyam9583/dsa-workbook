package com.technotap.dsaworkbook.util;

import java.util.Arrays;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 3, 4, 5, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) return;
        Partition p = partition(arr, start, end);
        quickSort(arr, start, p.left - 1);
        quickSort(arr, p.right + 1, end);
    }

    private static Partition partition(int[] arr, int start, int end) {
        int lt = start, gt = end, curr = start;
        int pivot = arr[start];
        while (curr <= gt) {
            switch (Integer.compare(arr[curr], pivot)) {
                case -1: {
                    swap(arr, curr++, lt++);
                    break;
                }
                case 1: {
                    swap(arr, curr++, gt--);
                    break;
                }
                default:
                    curr++;
            }
        }
        return new Partition(lt, gt);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static class Partition {
        int left, right;

        Partition(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
