package com.technotap.dsaworkbook.bitmanipulation;

public class SumOfBitDifference {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(sum(arr, arr.length));
    }

    private static long sum(int[] arr, int n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            long zeroes = 0, ones = 0;
            for (int val : arr) {
                if ((val & mask) == 0) ++zeroes;
                else ++ones;
            }
            result += zeroes * ones * 2;
        }
        return result;
    }
}
