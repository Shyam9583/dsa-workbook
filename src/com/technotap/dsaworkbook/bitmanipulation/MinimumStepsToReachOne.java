package com.technotap.dsaworkbook.bitmanipulation;

public class MinimumStepsToReachOne {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(minSteps(n));
    }

    private static int minSteps(int n) {
        if (n < 1) return -1;
        int count = 0;
        while (n != 1) {
            int remainder = n % 4;
            if (n == 3) {
                n -= 1;
            } else if (remainder == 1) {
                n -= 1;
            } else if (remainder == 3) {
                n += 1;
            } else {
                n /= 2;
            }
            count++;
        }
        return count;
    }
}
