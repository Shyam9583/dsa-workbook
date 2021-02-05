package string;

public class StringProblems {
    public static void main(String[] args) {
        String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y12X"};
        System.out.println(isShuffleOf(first, second, results[0]));
        System.out.println(isShuffleOf(first, second, results[1]));
    }

    private static boolean isShuffleOf(String first, String second, String result) {
        if (first.length() + second.length() != result.length())
            return false;
        int i = 0, j = 0, k = 0;
        while (k != result.length()) {
            if (i < first.length() && result.charAt(k) == first.charAt(i)) {
                i++;
            } else if (j < second.length() && result.charAt(k) == second.charAt(j)) {
                j++;
            } else {
                return false;
            }
            k++;
        }

        return i >= first.length() && j >= second.length();
    }

    private static boolean isPalindrome(String s) {
        boolean result = true;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            result = result & (s.charAt(i) == s.charAt(n - 1 - i));
        }
        return result;
    }

    private static void duplicateChars(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z')
                charCount[c - 'A']++;
            else if (c >= 'a' && c <= 'z')
                charCount[c - 'a']++;
        }
        System.out.println("Duplicate Characters in \" " + s + "\" : ");
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 1) {
                System.out.println("'" + (char) (i + 'a') + "' = " + charCount[i]);
            }
        }
    }


}
