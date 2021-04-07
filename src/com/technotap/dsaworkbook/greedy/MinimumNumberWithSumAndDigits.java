package com.technotap.dsaworkbook.greedy;

public class MinimumNumberWithSumAndDigits {

    public static void main(String[] args) {
        int S = 27, D = 4;
        System.out.println(number(S, D));
    }

    private static String number(int S, int D) {
        if (D * 9 < S) return String.valueOf(-1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < D - 1; i++) {
            int j = 9;
            while (j >= 0) {
                if (S - j > 0) break;
                j--;
            }
            result.insert(0, j);
            S -= j;
        }
        result.insert(0, S);
        return result.toString();
    }
}
