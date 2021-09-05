package com.technotap.dsaworkbook.util;

import java.util.Arrays;

public class MaxCoinPile {
    public static void main(String[] args) {
        int[] piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(maxCoins(piles));
    }

    private static int maxCoins(int[] piles) {
        if (piles.length == 0) return 0;
        Arrays.sort(piles);
        int result = 0;
        for (int me = piles.length - 2, bob = 0; me > bob; me -= 2, bob++) {
            result += piles[me];
        }
        return result;
    }
}
