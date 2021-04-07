package java.dynamicprogramming;

public class EditDistance {
    public static void main(String[] args) {
        String s = "geek", t = "gesek";
        System.out.println(editDistance(s, t));
    }

    private static int editDistance(String s, String t) {
        int[] dp = new int[t.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= s.length(); i++) {
            int prev = i - 1;
            dp[0] = i;
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                }
                prev = temp;
            }
        }
        return dp[dp.length - 1];
    }
}
