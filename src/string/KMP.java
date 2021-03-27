package string;

import java.util.ArrayList;

public class KMP {
    public static void main(String[] args) {
        String text = "aaaa";
        String pattern = "aa";
        System.out.println(kmp(text, pattern));
    }

    private static ArrayList<Integer> kmp(String text, String pattern) {
        int N = text.length(), M = pattern.length();
        ArrayList<Integer> positions = new ArrayList<>();

        int[] lps = lps(pattern, pattern.length());

        for (int i = 0, j = 0; i < N && j < M; ) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
            if (j == M) {
                positions.add(i - M);
                j = lps[j - 1];
            }
        }

        return positions;
    }

    private static int[] lps(String pattern, int M) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
