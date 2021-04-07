package com.technotap.dsaworkbook.string;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {
    public static void main(String[] args) {
        String A = "ilikesamsung";
        String[] dict = {"i", "like", "sam", "sung", "samsung", "mobile",
                "ice", "cream", "icecream", "man", "go", "mango"};
        ArrayList<String> B = new ArrayList<>(Arrays.asList(dict));
        wordBreak(A, "", B);
    }

    private static void wordBreak(String A, String ans, ArrayList<String> B) {
        if (A.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < A.length(); i++) {
            String left = A.substring(0, i + 1);
            if (B.contains(left)) {
                String right = A.substring(i + 1);
                wordBreak(right, ans + left + " ", B);
            }
        }
    }
}
