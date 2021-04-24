package com.technotap.dsaworkbook.bitmanipulation;

public class CountNumberOfSetBits {
    public static void main(String[] args) {
        int N = 9;
        System.out.println(setBits(N));
    }

    private static int setBits(int N) {
        if (N == 0) return 0;
        return (N & 1) + setBits(N >> 1);
    }
}
