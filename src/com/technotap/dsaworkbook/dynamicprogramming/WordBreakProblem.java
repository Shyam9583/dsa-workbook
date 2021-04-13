package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
    public static void main(String[] args) {
        String A = "pepcodinglovesmangoicecream";
        ArrayList<String> B = new ArrayList<>();
        Collections.addAll(B, "loves", "pep", "coding", "pepcoding", "ice", "cream", "icecream", "man", "go", "mango");
        System.out.println(wordBreak(A, B));
    }

    private static int wordBreak(String A, ArrayList<String> B) {
        Set<String> dict = new HashSet<>(B);
        int n = A.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(dict.contains(A.substring(j, i))) {
                    dp[i] += dp[j];
                }
            }
        }
        return Math.min(dp[n], 1);
    }

}
