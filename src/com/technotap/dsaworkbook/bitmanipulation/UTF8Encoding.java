package com.technotap.dsaworkbook.bitmanipulation;

public class UTF8Encoding {
    public static void main(String[] args) {
        int[] data = {0b11101111, 0b10111100, 0b10010111, 0b11011111, 0b10000000, 0b11110010, 0b10010101, 0b10001111, 0b10111111};
        System.out.println(isValid(data));
    }

    private static boolean isValid(int[] data) {
        int next = 0;
        for (int val : data) {
            if (val >= 255) return false;
            if (next == 0) {
                if (val >> 7 == 0) continue;
                if (val >> 6 == 0b10) return false;
                next = (val >> 5 == 0b110 ? 1 : 0) + (val >> 4 == 0b1110 ? 1 : 0) * 2 + (val >> 3 == 0b11110 ? 1 : 0) * 3;
            } else if (val >> 6 == 0b10) --next;
            else return false;
        }
        return next == 0;
    }
}
