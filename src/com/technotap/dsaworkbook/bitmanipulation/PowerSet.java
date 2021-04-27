package com.technotap.dsaworkbook.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(allPossibleStrings(s));
    }

    private static List<String> allPossibleStrings(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) builder.append(s.charAt(j));
            }
            if (builder.length() > 0) result.add(builder.toString());
        }
        result.sort(String::compareTo);
        return result;
    }
}
