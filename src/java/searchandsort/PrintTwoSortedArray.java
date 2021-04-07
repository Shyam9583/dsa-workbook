package java.searchandsort;

import java.util.Arrays;

public class PrintTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 10, 15};
        int[] arr2 = {2, 2, 2, 7, 10, 12, 14, 14, 17, 20};
        optimumMerge(arr1, arr2, arr1.length, arr2.length);
        Arrays.stream(arr1).forEach(e -> System.out.print(e + " "));
        Arrays.stream(arr2).forEach(e -> System.out.print(e + " "));
    }

    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {
            int j, last = arr1[n - 1];
            for (j = n - 2; j >= 0 && arr1[j] >= arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j != n - 2 && last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static void betterMerge(int[] arr1, int[] arr2, int n, int m) {
        for (int i = 0; i < n; i++) {
            // check if arr1 element is greater and swap with first element of arr2
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            // put swapped element in its rightful place inside sorted arr2
            for (int j = 0; j < m - 1 && arr2[j + 1] < arr2[j]; j++) {
                int temp = arr2[j];
                arr2[j] = arr2[j + 1];
                arr2[j + 1] = temp;
            }
        }
    }

    private static void optimumMerge(int[] arr1, int[] arr2, int n, int m) {
        int gap = n + m;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = 0; (i + gap < n + m); i++) {
                int right = i + gap;
                if (i < n && right < n) {
                    if (arr1[i] > arr1[right]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[right];
                        arr1[right] = temp;
                    }
                }
                if (i < n && right >= n) {
                    if (arr1[i] > arr2[right - n]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                if (i >= n && right >= n) {
                    if (arr2[i - n] > arr2[right - n]) {
                        int temp = arr2[i - n];
                        arr2[i - n] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
            }
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
}
