package searchandsort;

import java.util.Arrays;

public class SpaceEfficientMergeSort {
    public static void main(String[] args) {
        int[] arr = {56, 2, 45};
        mergesSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergesSort(arr, l, m);
            mergesSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int gap = (r - l + 1);
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = l; i + gap <= r; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                }
            }
        }
    }

    private static int nextGap(int gap) {
        if (gap == 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
}
