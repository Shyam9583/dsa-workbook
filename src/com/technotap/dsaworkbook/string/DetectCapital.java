package com.technotap.dsaworkbook.string;

import java.util.function.Predicate;

public class DetectCapital {

    public static void main(String[] args) {
        String s = "Aaaaa";
        System.out.println(detectCapital(s));
    }

    private static boolean detectCapital(String string) {
        if (string.length() <= 1) return true;
        Predicate<Character> correctCase = Character::isLowerCase;
        if (Character.isUpperCase(string.charAt(0)) && Character.isUpperCase(string.charAt(1))) {
            correctCase = Character::isUpperCase;
        }
        for (int i = 0; i < string.length(); i++) {
            if (!correctCase.test(string.charAt(i))) return false;
        }
        return true;
    }
}
