package com.technotap.dsaworkbook.bitmanipulation;

public class CheckIfNumberIsPowerOfTwo {
    public static void main(String[] args) {
        long n = 11;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(long n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }
}
