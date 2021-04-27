package com.technotap.dsaworkbook.bitmanipulation;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = Integer.MAX_VALUE, divisor = 2;
        System.out.println(divide(dividend, divisor));
    }

    private static int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        boolean negative = (dividend < 0) ^ (divisor < 0);
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        int quotient = 0;
        while (dividend >= divisor) {
            int i = 1, accumulator = divisor;
            while (dividend >= accumulator) {
                i <<= 1;
                accumulator <<= 1;
            }
            quotient += i >> 1;
            dividend -= (accumulator >> 1);
        }
        return negative ? -quotient : quotient;
    }
}
