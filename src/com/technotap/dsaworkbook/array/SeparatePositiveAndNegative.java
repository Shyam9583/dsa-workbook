package com.technotap.dsaworkbook.array;

import java.util.Arrays;

public class SeparatePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr));
        separate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void separate(int[] arr) {
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (arr[j] < 0 && i != j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
