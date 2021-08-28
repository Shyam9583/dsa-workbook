package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;

public class ChooseAndSwap {
    public static void main(String[] args) {
        String S = "abcdefghijklabcdefghijklpop";
        long start = System.nanoTime();
        System.out.println(chooseAndSwap(S));
        System.out.println(System.nanoTime() - start);
    }

    /*
     * Find the character smaller than current character whose left most appearance is greater than current character's.
     * We can then check if such character exists and then swap, else just return the original string as it will be lexicographically smaller.
     */
    private static String chooseAndSwap(String S) {
        int N = S.length();
        char[] chars = S.toCharArray();
        int[] left = new int[26];
        Arrays.fill(left, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            if (left[chars[i] - 'a'] != Integer.MIN_VALUE) continue;
            left[chars[i] - 'a'] = i;
        }
        char changeFrom = 0, changeTo = 0;
        for (int i = 0; i < N; i++) {
            changeTo = changeFrom = chars[i];
            for (char c = 'a'; c < chars[i]; c++) {
                if (left[c - 'a'] <= left[chars[i] - 'a']) continue;
                changeTo = c;
                break;
            }
        }
        if (changeFrom == changeTo) return S;
        for (int i = 0; i < N; i++) {
            if (chars[i] == changeFrom) chars[i] = changeTo;
            else if (chars[i] == changeTo) chars[i] = changeFrom;
        }
        return new String(chars);
    }
}
