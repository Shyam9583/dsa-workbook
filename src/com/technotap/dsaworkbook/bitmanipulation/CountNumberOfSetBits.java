package com.technotap.dsaworkbook.bitmanipulation;

public class CountNumberOfSetBits {
    public static void main(String[] args) {
        int N = 57;
        System.out.println(setBits(N));
    }

    private static int setBits(int N) {
        int count = 0;
        while (N > 0) {
            int mask = N & -N;
            N -= mask;
            count++;
        }
        return count;
    }
}
