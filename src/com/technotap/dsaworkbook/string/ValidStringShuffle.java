package com.technotap.dsaworkbook.string;

import java.util.Arrays;

public class ValidStringShuffle {
    public static void main(String[] args) {
        String first = "XY", second = "12", result = "X21X";
        System.out.println(isValidShuffle(first, second, result));
    }

    private static boolean isValidShuffle(String first, String second, String result) {
        return first.length() + second.length() == result.length() && checkShuffle(first, second, result);
    }

    private static boolean checkShuffle(String first, String second, String result) {
        char[] original = first.concat(second).toCharArray();
        char[] shuffled = result.toCharArray();
        Arrays.sort(original);
        Arrays.sort(shuffled);
        return Arrays.equals(original, shuffled);
    }
}
