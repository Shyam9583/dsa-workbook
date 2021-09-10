package com.technotap.dsaworkbook.util;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitionOfString {
    public static void main(String[] args) {
        String s = "geeks";
        partitions(s).forEach(System.out::println);
    }

    private static List<String> partitions(String s) {
        List<String> result = new ArrayList<>();
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];

        for (int g = 0; g < N; g++) {
            for (int i = 0, j = g; j < N; i++, j++) {
                if (g == 0) {
                    isPalindrome[i][j] = true;
                    continue;
                }
                boolean isSame = s.charAt(i) == s.charAt(j);
                if (g == 1) isPalindrome[i][j] = isSame;
                else isPalindrome[i][j] = isSame && isPalindrome[i + 1][j - 1];
            }
        }

        partitionUtil(s, "", result, isPalindrome, 0, N - 1);

        return result;
    }

    private static void partitionUtil(String original, String resultant, List<String> result, boolean[][] isPalindrome, int start, int end) {
        if (start < 0 || end >= isPalindrome.length) return;
        if (original.isEmpty()) {
            result.add(resultant.substring(1));
            return;
        }
        for (int i = start; i <= end; i++) {
            if (!isPalindrome[start][i]) continue;
            String sub = original.substring(0, i - start + 1);
            partitionUtil(original.substring(i - start + 1), resultant + " " + sub, result, isPalindrome, i + 1, end);
        }
    }
}
