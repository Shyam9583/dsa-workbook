package string;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABC", s2 = "AC";
        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
        System.out.println(longestCommonSubstring(s1.length(), s2.length(), s1, s2, 0));
    }

    private static int lcs(int M, int N, String s1, String s2) {
        if (M == 0 || N == 0)
            return 0;
        else if (s1.charAt(M - 1) == s2.charAt(N - 1)) {
            return 1 + lcs(M - 1, N - 1, s1, s2);
        } else {
            return Math.max(lcs(M - 1, N, s1, s2), lcs(M, N - 1, s1, s2));
        }
    }

    private static int longestCommonSubstring(int i, int j, String s1, String s2, int count) {
        if (i == 0 || j == 0)
            return count;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1))
            count = longestCommonSubstring(i - 1, j - 1, s1, s2, count + 1);
        count = Math.max(count, Math.max(longestCommonSubstring(i - 1, j, s1, s2, 0), longestCommonSubstring(i, j - 1, s1, s2, 0)));
        return count;
    }
}
