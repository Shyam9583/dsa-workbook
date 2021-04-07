package com.technotap.dsaworkbook.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strings = { "flower", "flow", "flight"};
        String[] strings = {"ab", "ac"};
        System.out.println(lcp(strings));
    }

    private static String lcp(String[] strings) {
        if (strings.length == 0)
            return "";
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
