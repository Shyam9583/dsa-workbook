package com.technotap.dsaworkbook.greedy;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    /*
     * Use match count concept to solve it.
     * if cnt(s) <= cnt(t) ++matchCount
     * if (cnt(s) < cnt(t) --matchCount
     */
    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int countLength = 'z' - 'A' + 1;
        int[] tCount = new int[countLength], sCount = new int[countLength];
        char[] arrS = s.toCharArray();
        for (char ch : t.toCharArray()) tCount[ch - 'A']++;
        int start = 0, end = 0;
        int matchCount = 0;
        String minWindow = "";
        while (end < s.length()) {
            while (matchCount < t.length()) {
                if (++sCount[arrS[end] - 'A'] <= tCount[arrS[end] - 'A']) {
                    matchCount++;
                }
                if (++end == s.length()) break;
            }
            while (matchCount == t.length()) {
                String curr = s.substring(start, end);
                if (minWindow.isEmpty() || minWindow.length() > curr.length()) {
                    minWindow = curr;
                }
                if (--sCount[arrS[start] - 'A'] < tCount[arrS[start] - 'A']) {
                    matchCount--;
                }
                start++;
            }
        }
        return minWindow;
    }
}
