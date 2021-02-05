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
        int[] sp = new int[M];
        int i = 1, j = 0;
        ArrayList<Integer> positions = new ArrayList<>();

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                sp[i] = j + 1;
                j++;
                i++;
            } else if (j > 0) {
                j = sp[j - 1];
            } else {
                i++;
            }
        }

        i = 0;
        j = 0;

        while (i < N && j < M) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = sp[j - 1];
            } else {
                i++;
            }
            if (j == M) {
                positions.add(i - M);
                j = sp[j - 1];
            }
        }

        return positions;
    }
}
