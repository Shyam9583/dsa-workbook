package com.technotap.dsaworkbook.bitmanipulation;

public class NthBinaryPalindrome {
    public static void main(String[] args) {
        int n = 29;
        System.out.println(nthPalindrome(n));
    }

    private static int nthPalindrome(int n) {
        int count = 1, len = 1;
        while (count < n) {
            len++;
            count += (1 << (len - 1) / 2);
        }
        count -= (1 << (len - 1) / 2);
        int offset = n - count - 1;
        int result = (1 << (len - 1));
        result |= (offset << len / 2);
        result |= reverse(result >> len / 2);
        return result;
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
