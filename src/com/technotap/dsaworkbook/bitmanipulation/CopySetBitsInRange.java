package com.technotap.dsaworkbook.bitmanipulation;

public class CopySetBitsInRange {
    public static void main(String[] args) {
        int x = 10, y = 13, l = 2, r = 3;
        System.out.println(copySetBits(x, y, l, r));
    }

    private static int copySetBits(int x, int y, int l, int r) {
        int bitMask = (1 << (r - l + 1)) - 1;
        bitMask = (bitMask << l - 1) & y;
        return bitMask | x;
    }
}
