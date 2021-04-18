package com.technotap.dsaworkbook.dynamicprogramming;

public class PalindromicPartitions {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    private static int palindromicPartition(String str) {
        int N = str.length();
        boolean[][] isPalindrome = new boolean[N][N];
        for (int g = 0; g < N; g++) {
            for (int i = 0, j = g; j < N; i++, j++) {
                if (g == 0) {
                    isPalindrome[i][j] = true;
                    continue;
                }
                boolean equals = str.charAt(i) == str.charAt(j);
                if (g == 1) isPalindrome[i][j] = equals;
                else isPalindrome[i][j] = equals && isPalindrome[i + 1][j - 1];
            }
        }
        int[][] dp = new int[N][N];
        return palindromicPartitionRec(0, N - 1, isPalindrome, dp);
    }

    private static int palindromicPartitionRec(int i, int j, boolean[][] isPalindrome, int[][] dp) {
        if (isPalindrome[i][j]) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int c = i; c <= j; c++) {
            if (isPalindrome[i][c]) {
                min = Math.min(min, palindromicPartitionRec(c + 1, j, isPalindrome, dp));
            }
        }
        dp[i][j] = min + 1;
        return dp[i][j];
    }
}
