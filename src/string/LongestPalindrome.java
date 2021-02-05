package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {

    static int maxStart = 0;
    static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases;
        testCases = Integer.parseInt(bufferedReader.readLine());
        for (int test = 0; test < testCases; test++) {
            String string = bufferedReader.readLine();
            System.out.println(longestPalindrome(string));
        }
    }

    private static String longestPalindrome(String string) {
        if (string.length() < 2)
            return string;
        for (int i = 0; i < string.length() - 1; i++) {
            expandCharacter(string, i, i);
            expandCharacter(string, i, i + 1);
        }
        return string.substring(maxStart, maxStart + maxLength);
    }

    private static void expandCharacter(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        if (end - start - 1 > maxLength) {
            maxStart = start + 1;
            maxLength = end - start - 1;
        }
    }
}
