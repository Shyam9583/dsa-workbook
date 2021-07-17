package com.technotap.dsaworkbook.string;

public class CheckIfStringIsARotation {
    public static void main(String[] args) {
        String str1 = "ABCD", str2 = "CDAB";
        System.out.println(isRotation(str1, str2));
    }

    private static boolean isRotation(String str1, String str2) {
        return (str1.concat(str1)).contains(str2);
    }
}
