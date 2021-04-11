package com.technotap.dsaworkbook.dynamicprogramming;

public class MaxDifferenceOf01InBinaryString {
    public static void main(String[] args) {
        String S = "11000010001";
        System.out.println(maxDifference(S));
    }

    private static int maxDifference(String S) {
        int maxSoFar = -1, maxTillNow = 0;
        for (int i = 0; i < S.length(); i++) {
            maxTillNow += S.charAt(i) == '0' ? 1 : -1;
            maxSoFar = Math.max(maxSoFar, maxTillNow);
            maxTillNow = Math.max(maxTillNow, 0);
        }
        return maxSoFar;
    }
}
