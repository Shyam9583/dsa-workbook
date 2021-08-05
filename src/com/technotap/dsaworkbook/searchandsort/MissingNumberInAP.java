package com.technotap.dsaworkbook.searchandsort;

public class MissingNumberInAP {
    public static void main(String[] args) {
        int A = 1, B = 3, C = 2;
        System.out.println(inSequence(A, B, C));
    }

    private static int inSequence(int A, int B, int C) {
        if (C == 0) return A == B ? 1 : 0;
        return isInteger((B - A) / (double) C) ? 1 : 0;
    }

    private static boolean isInteger(double n) {
        return n >= 0 && n % 1 == 0;
    }
}
