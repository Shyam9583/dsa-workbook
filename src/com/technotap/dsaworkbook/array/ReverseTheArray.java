package com.technotap.dsaworkbook.array;

import java.util.Arrays;

public class ReverseTheArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; ++i, --j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
