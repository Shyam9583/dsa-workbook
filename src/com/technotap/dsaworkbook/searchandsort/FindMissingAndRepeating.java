package com.technotap.dsaworkbook.searchandsort;

public class FindMissingAndRepeating {

    public static void main(String[] args) {
        int[] arr = {2, 2};
        int[] result = repeatingAndMissing(arr, arr.length);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] repeatingAndMissing(int[] arr, int n) {
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int absolute = Math.abs(arr[i]);
            if (arr[absolute] > 0)
                arr[absolute - 1] = -arr[absolute - 1];
            else
                result[0] = absolute;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                result[1] = i + 1;
        }
        return result;
    }
}
