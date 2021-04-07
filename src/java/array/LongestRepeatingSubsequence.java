package java.array;

import java.util.ArrayList;

public class LongestRepeatingSubsequence {

    static ArrayList<String> subsequences = new ArrayList<>();

    public static void main(String[] args) {
        findSubsequence("abcd", "");
        System.out.println(subsequences);
    }

    private static int LRS(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N][N];
    }

    private static void findSubsequence(String s, String result) {
        if (s.length() == 0) {
            subsequences.add(result);
            return;
        }
        findSubsequence(s.substring(1), result + s.charAt(0));
        findSubsequence(s.substring(1), result);
    }
}
