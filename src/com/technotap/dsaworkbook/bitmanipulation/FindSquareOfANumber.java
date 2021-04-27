package com.technotap.dsaworkbook.bitmanipulation;

public class FindSquareOfANumber {
    public static void main(String[] args) {
        int n = -5;
        System.out.println(square(n));
    }

    private static int square(int n) {
        int result = 0;
        int original = n = n < 0 ? -n : n;
        for (int i = 0; n > 0; i++, n >>= 1) {
            if ((n & 1) == 1) {
                result += original << i;
            }
        }
        return result;
    }
}
