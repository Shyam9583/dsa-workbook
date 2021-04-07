package java.string;

import java.util.HashMap;

public class RomanToDecimal {

    private static final HashMap<Character, Integer> ROMAN = new HashMap<>();

    public static void main(String[] args) {
        String roman = "XXIII";
        init();
        System.out.println(toDecimal(roman));
    }

    private static int toDecimal(String roman) {
        int sum = 0;
        int i = 0;
        if (roman.isEmpty())
            return -1;
        if (roman.length() == 1)
            return value(roman.charAt(0));
        while (i < roman.length()) {
            if (i + 1 < roman.length()) {
                if (value(roman.charAt(i)) >= value(roman.charAt(i + 1))) {
                    sum += value(roman.charAt(i));
                    i++;
                } else {
                    sum -= value(roman.charAt(i));
                    sum += value(roman.charAt(i + 1));
                    i++;
                }
            } else {
                sum += value(roman.charAt(i));
                i++;
            }
        }
        return sum;
    }

    private static int value(char roman) {
        return ROMAN.get(roman);
    }

    private static void init() {
        ROMAN.put('I', 1);
        ROMAN.put('V', 5);
        ROMAN.put('X', 10);
        ROMAN.put('L', 50);
        ROMAN.put('C', 100);
        ROMAN.put('D', 500);
        ROMAN.put('M', 1000);
    }
}
