package com.technotap.dsaworkbook.bitmanipulation;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(reverse(n));
    }

    private static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev <<= 1;
            rev ^= (n & 1);
            n >>= 1;
        }
        return rev;
    }
}
