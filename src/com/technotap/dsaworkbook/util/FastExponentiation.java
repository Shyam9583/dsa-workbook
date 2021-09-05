package com.technotap.dsaworkbook.util;

public class FastExponentiation {
    public static void main(String[] args) {
        int a = 2, n = 11;
        System.out.println(exponent(a, n));
    }

    private static long exponent(int a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a;
        long result = exponent(a, n / 2);
        result = result * result;
        if (n % 2 == 1) result *= a;
        return result;
    }
}
