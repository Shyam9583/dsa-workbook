package com.technotap.dsaworkbook.dynamicprogramming;

public class CountDerangementPermutations {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(count(n));
    }

    private static int count(int n) {
        if (n < 2) return 0;
        int curr = 1, prev = 0, temp;
        for (int i = 3; i <= n; i++) {
            temp = curr;
            curr = (i - 1) * (curr + prev);
            prev = temp;
        }
        return curr;
    }
}
