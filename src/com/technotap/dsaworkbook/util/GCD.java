package com.technotap.dsaworkbook.util;

public class GCD {
    public static void main(String[] args) {
        int a = 15, b = 5;
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
