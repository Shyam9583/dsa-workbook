package com.technotap.dsaworkbook.bitmanipulation;

public class CountNumbersWithSameNumberOfSetBits {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(count(n));
    }

    private static int count(int n) {
        int nSetBits = 0;
        int temp = n, mask;
        while (temp > 0) {
            mask = temp & -temp;
            nSetBits++;
            temp -= mask;
        }
        return countRec(n, nSetBits);
    }

    private static int countRec(int n, int required) {
        if (n == 0) return 0;
        int count = 0;
        for (int i = n; i > 0; i >>= 1) {
            count++;
        }
        if (count < required) return 0;
        return nCr(count - 1, required) + countRec(n - (1 << (count - 1)), required - 1);
    }

    private static int nCr(int n, int r) {
        int result = 1;
        for (int i = 1; i <= r; i++) {
            result = (result * (n - i + 1)) / i;
        }
        return result;
    }
}
