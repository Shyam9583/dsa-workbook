package com.technotap.dsaworkbook.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinFlipsRequired {
    public static void main(String[] args) throws IOException {
        String input;
        int tests;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        tests = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
        for (int i = 0; i < tests; i++) {
            input = reader.readLine().trim();
            System.out.println(minFlips(input));
        }
    }

    private static int minFlips(String binary) {
        StringBuilder alternate = new StringBuilder(inverse(binary.charAt(0)) + binary.substring(1));
        return Math.min(flips(new StringBuilder(binary)), flips(alternate) + 1);
    }

    private static int flips(StringBuilder s) {
        int flips = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s.setCharAt(i + 1, inverse(s.charAt(i + 1)));
                flips += 1;
            }
        }
        return flips;
    }

    private static char inverse(char bit) {
        return (char) (('0' + '1') - bit);
    }
}
