package com.technotap.dsaworkbook.bitmanipulation;

public class FindRepeatingAndMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 5, 1, 2, 7};
        printMissingAndRepeating(arr, arr.length);
    }

    private static void printMissingAndRepeating(int[] arr, int n) {
        int xor = 0;
        for (int val : arr) xor ^= val;
        for (int i = 1; i <= n; i++) xor ^= i;
        int rsb = xor & -xor;
        int x = 0, y = 0;
        for (int val : arr) {
            if ((val & rsb) == 0) x ^= val;
            else y ^= val;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rsb) == 0) x ^= i;
            else y ^= i;
        }
        for (int val : arr) {
            if (val == x) {
                System.out.println("Repeating -> " + x + "\nMissing -> " + y);
                break;
            } else if (val == y) {
                System.out.println("Repeating -> " + y + "\nMissing -> " + x);
                break;
            }
        }
    }
}
