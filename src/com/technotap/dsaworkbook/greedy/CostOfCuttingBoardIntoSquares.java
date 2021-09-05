package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;
import java.util.Collections;

public class CostOfCuttingBoardIntoSquares {
    public static void main(String[] args) {
        int m = 6, n = 4;
        Integer[] X = {2, 1, 3, 1, 4};
        Integer[] Y = {4, 1, 2};
        System.out.print(cost(X, Y, m - 1, n - 1));
    }

    private static int cost(Integer[] hCost, Integer[] vCost, int m, int n) {
        Arrays.sort(hCost, Collections.reverseOrder());
        Arrays.sort(vCost, Collections.reverseOrder());

        int hPieces = 1, vPieces = 1, total = 0, i = 0, j = 0;

        while (i < m && j < n) {
            if (hCost[i] > vCost[j]) {
                total += hCost[i] * hPieces;
                vPieces++;
                i++;
            } else {
                total += vCost[j] * vPieces;
                hPieces++;
                j++;
            }
        }

        int restCost = 0;
        while (i < m) restCost += hCost[i++];
        total += restCost * hPieces;
        restCost = 0;
        while (j < n) restCost += vCost[j++];
        total += restCost * vPieces;

        return total;
    }
}
