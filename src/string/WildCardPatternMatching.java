package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WildCardPatternMatching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string, pattern;
        int testcases = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
        for (int t = 0; t < testcases; t++) {
            pattern = reader.readLine().trim();
            string = reader.readLine().trim();
            if (matches(string, pattern, string.length(), pattern.length()))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    // modified common substring approach
    private static boolean matches(String string, String pattern, int M, int N) {
        boolean[][] match = new boolean[M + 1][N + 1];

        // empty string matched with empty string
        match[0][0] = true;

        // modify first row value for '*' symbol
        for (int i = 1; i <= N; i++) {
            if (pattern.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 1];
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (string.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                }
            }
        }

        return match[M][N];
    }
}
