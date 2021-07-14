package com.technotap.dsaworkbook.util;

public class LCM {
    public static void main(String[] args) {
        int a = 15, b = 5;
        System.out.println(lcm(a, b));
    }

    public static int lcm(int a, int b) {
        return (a * b) / GCD.gcd(a, b);
    }
}
