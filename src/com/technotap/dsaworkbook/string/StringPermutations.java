package com.technotap.dsaworkbook.string;

import java.util.ArrayList;

public class StringPermutations {

    static ArrayList<String> permutations = new ArrayList<>();

    public static void main(String[] args) {
        String string = "abc";
        permute(new StringBuilder(string), 0, string.length() - 1);
    }

    private static void permute(StringBuilder s, int left, int right) {

        if (left == right) {
            System.out.println(s.toString());
        }
        for (int i = left; i <= right; i++) {
            swap(s, left, i);
            permute(s, left + 1, right);
            swap(s, left, left);
        }
    }

    private static void swap(StringBuilder s, int i1, int i2) {
        char temp = s.charAt(i1);
        s.setCharAt(i1, s.charAt(i2));
        s.setCharAt(i2, temp);
    }
}
