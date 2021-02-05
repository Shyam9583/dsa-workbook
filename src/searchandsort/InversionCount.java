package searchandsort;

import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(inversionCount(arr, arr.length));
    }

    private static int inversionCount(int[] arr, int N) {
        return mergeSort(arr, 0, N - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        int swaps = 0;
        if (l < r) {
            int m = (l + r) / 2;
            swaps += mergeSort(arr, l, m);
            swaps += mergeSort(arr, m + 1, r);
            swaps += merge(arr, l, m, r);
        }
        return swaps;
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int count = 0;
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (m + 1) - (l + i);
            }
        }
        return count;
    }
}
