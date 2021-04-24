package com.technotap.dsaworkbook.bitmanipulation;

public class BitDifference {
    public static void main(String[] args) {
        int a = 20, b = 25;
        System.out.println(countBitFlips(a, b));
    }

    private static int countBitFlips(int a, int b) {
        int xor = a ^ b;
        return countSetBits(xor);
    }

    private static int countSetBits(int N) {
        if (N == 0) return 0;
        return (N & 1) + countSetBits(N >> 1);
    }
}
