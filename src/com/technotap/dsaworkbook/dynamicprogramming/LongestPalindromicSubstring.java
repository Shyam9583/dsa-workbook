package com.technotap.dsaworkbook.dynamicprogramming;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(longestPalindromeOptimized(s));
    }

    private static String longestPalindromeOptimized(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int start, int end) {
        if (s == null || start > end) return 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
