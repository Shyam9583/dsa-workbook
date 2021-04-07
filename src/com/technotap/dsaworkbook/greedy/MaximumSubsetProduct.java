package com.technotap.dsaworkbook.greedy;

public class MaximumSubsetProduct {

    public static void main(String[] args) {
        int[] arr = {-1, -1, -2, 4, 3};
        System.out.println(maxProduct(arr, arr.length));
    }

    private static int maxProduct(int[] arr, int n) {
        int nZeroes = 0, nNegative = 0, maxNegative = Integer.MIN_VALUE, product = 1;
        for (int item : arr) {
            if (item == 0) {
                nZeroes++;
                continue;
            }
            if (item < 0) {
                nNegative++;
                maxNegative = Math.max(maxNegative, item);
            }
            product *= item;
        }
        if (nZeroes == n) return 0;
        if ((nNegative & 1) == 1) {
            if (nNegative == 1 && nZeroes > 0 && nZeroes + nNegative == n)
                return 0;
            return product / maxNegative;
        }
        return product;
    }


}
