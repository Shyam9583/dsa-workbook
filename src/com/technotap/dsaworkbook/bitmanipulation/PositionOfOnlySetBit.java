package com.technotap.dsaworkbook.bitmanipulation;

public class PositionOfOnlySetBit {
    public static void main(String[] args) {
        int N = 1;
        System.out.println(findPosition(N));
    }

    private static int findPosition(int N) {
        if (!isPowerOfTwo(N)) return -1;
        int i = 1, pos = 1;
        while ((N & i) == 0) {
            i <<= 1;
            pos++;
        }
        return pos;
    }

    private static boolean isPowerOfTwo(int N) {
        if (N == 0) return false;
        return (N & (N - 1)) == 0;
    }
}
