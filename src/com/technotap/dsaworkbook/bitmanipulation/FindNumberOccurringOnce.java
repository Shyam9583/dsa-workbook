package com.technotap.dsaworkbook.bitmanipulation;

public class FindNumberOccurringOnce {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 3};
        System.out.println(search(arr, arr.length));
    }

    private static int search(int[] arr, int n) {
        int xor = 0;
        for (int val : arr) xor ^= val;
        return xor;
    }
}
