package com.technotap.dsaworkbook.bitmanipulation;

public class PrintAllAbbreviations {
    public static void main(String[] args) {
        String str = "pep";
        print(str);
    }

    private static void print(String str) {
        int len = str.length();
        for (int i = 0; i < 1 << len; i++) {
            StringBuilder builder = new StringBuilder();
            int count = 0;
            for (int j = len - 1; j >= 0; j--) {
                if ((i & (1 << j)) != 0) {
                    count++;
                    continue;
                }
                if (count > 0) {
                    builder.append(count);
                    count = 0;
                }
                builder.append(str.charAt(j));
            }
            if (count > 0) {
                builder.append(count);
            }
            System.out.println(builder);
        }
    }
}
