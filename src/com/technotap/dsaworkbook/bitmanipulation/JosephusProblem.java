package com.technotap.dsaworkbook.bitmanipulation;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(survivor(n));
    }

    private static int survivor(int n) {
        int power = highestPowerOfTwo(n);
        int l = n - power;
        return (l << 1) + 1;
    }

    private static int highestPowerOfTwo(int n) {
        int i = 1;
        while (i <= n) {
            i <<= 1;
        }
        return i >> 1;
    }
}
