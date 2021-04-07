package com.technotap.dsaworkbook.backtracking;

public class PrintAllPossiblePalindromicPartitions {
    public static void main(String[] args) {
        String s = "nitin";
        print(s);
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private static void print(String s) {
        printUtil(s, "");
    }

    private static void printUtil(String original, String result) {
        if (original.length() == 0)
            System.out.println(result);
        else {
            for (int i = 0; i < original.length(); i++) {
                String prefix = original.substring(0, i + 1);
                String suffix = original.substring(i + 1);
                if (isPalindrome(prefix)) {
                    printUtil(suffix, prefix + " " + result);
                }
            }
        }
    }
}
