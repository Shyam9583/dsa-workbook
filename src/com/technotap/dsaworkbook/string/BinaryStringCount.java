package com.technotap.dsaworkbook.string;

import java.util.ArrayList;

public class BinaryStringCount {

    private static final ArrayList<String> binaries = new ArrayList<>();

    public static void main(String[] args) {
        String binary = "0111100010";
        split(binary);
        System.out.println(binaries);
    }

    private static void split(String s) {
        int startIndex = 0, zeroes = 0, ones = 0;
        boolean touched = false;

        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            if (bit == '0') {
                if (startIndex == 0 && !touched) {
                    startIndex = i;
                    touched = true;
                }
                zeroes++;
            } else if (bit == '1') {
                if (startIndex == 0 && !touched) {
                    startIndex = i;
                    touched = true;
                }
                ones++;
            }
            if (zeroes == ones) {
                binaries.add(s.substring(startIndex, i + 1));
                startIndex = 0;
                touched = false;
            }
        }
    }
}
