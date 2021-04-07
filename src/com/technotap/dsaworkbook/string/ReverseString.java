package com.technotap.dsaworkbook.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] string = "Hello".toCharArray();
        reverseString(string);
        System.out.println(Arrays.toString(string));
    }

    private static void reverseString(char[] chars) {
        char temp;
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
    }
}
