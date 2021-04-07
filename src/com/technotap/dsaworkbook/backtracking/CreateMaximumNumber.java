package com.technotap.dsaworkbook.backtracking;

public class CreateMaximumNumber {

    private static String maxValue;

    public static void main(String[] args) {
        String number = "3435335";
        int k = 3;
        System.out.println(maxNumber(number, k));
    }

    private static String maxNumber(String str, int k) {
        if (str.isEmpty()) return str;
        maxValue = str;
        maxNumberUtil(str, k, str.length());
        return maxValue;
    }

    private static void maxNumberUtil(String s, int k, int n) {
        if (k == 0) return;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) < s.charAt(j)) {
                    s = swap(s, i, j);
                    maxValue = maxValue.compareTo(s) < 0 ? s : maxValue;
                    maxNumberUtil(s, k - 1, n);
                    s = swap(s, i, j);
                }
            }
        }
    }

    private static String swap(String s, int i, int j) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
