package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;

public class SortedUsingBinaryBit {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortByBitCount(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortByBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, ((o1, o2) -> Integer.compare(countSetBits(o2), countSetBits(o1))));
    }

    private static int countSetBits(int i) {
        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = (i + (i >> 4)) & 0x0f0f0f0f;
        i = i + (i >> 8);
        i = i + (i >> 16);
        return i & 0x3f;
    }
}
