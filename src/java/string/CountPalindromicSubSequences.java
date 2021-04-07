package java.string;

public class CountPalindromicSubSequences {
    public static void main(String[] args) {
        String s = "mqbhcdarzowkkyhi";
        System.out.println(countPalindromicSubSequences(s));
    }

    private static int countPalindromicSubSequences(String s) {
        int N = s.length();
        int[][] count = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++)
            count[i][i] = 1;

        for (int j = 2; j <= N; j++) {
            for (int i = 0; i < N; i++) {
                int k = j + i - 1;
                if (k < N) {
                    if (s.charAt(i) == s.charAt(k)) {
                        count[i][k] = count[i][k - 1] + count[i + 1][k] + 1;
                    } else {
                        count[i][k] = count[i][k - 1] + count[i + 1][k] - count[i + 1][k - 1];
                    }
                }
            }
        }

        return count[0][N - 1];
    }
}
