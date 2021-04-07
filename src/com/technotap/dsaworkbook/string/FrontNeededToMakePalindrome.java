package com.technotap.dsaworkbook.string;

public class FrontNeededToMakePalindrome {
    public static void main(String[] args) {
        String s = "AACECAAAA";
        System.out.println(neededCharacters(s));
    }

    // we use lps java.dsaworkbook.array of kmp algorithm
    private static int neededCharacters(String original) {
        String reversed = new StringBuilder(original).reverse().toString();
        String joined = original + '$' + reversed;
        int[] lps = lps(joined, joined.length());
        return original.length() - lps[joined.length() - 1];
    }

    private static int[] lps(String string, int N) {
        int[] lps = new int[N];
        int len = 0, i = 1;
        while (i < N) {
            if (string.charAt(i) == string.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
