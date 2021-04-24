package com.technotap.dsaworkbook.bitmanipulation;

public class CountTotalSetBits {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(countSetBits(n));
    }

    private static int countSetBits(int n) {
        if (n == 0) return 0;
        int pwr = highestPower(n);
        int pwrNum = 1 << pwr;
        int nextN = n - pwrNum;
        return ((pwrNum >> 1) * pwr) + (nextN + 1) + countSetBits(nextN);
    }

    private static int highestPower(int n) {
        int power = 0;
        while ((1 << power) <= n) power++;
        return power - 1;
    }
}
