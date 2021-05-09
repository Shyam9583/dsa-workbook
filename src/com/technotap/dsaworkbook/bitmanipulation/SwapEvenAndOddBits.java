package com.technotap.dsaworkbook.bitmanipulation;

public class SwapEvenAndOddBits {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(swap(n));
    }

    private static int swap(int n) {
        return (0xAAAAAAAA & n) >> 1 | (0x55555555 & n) << 1;
    }
}
