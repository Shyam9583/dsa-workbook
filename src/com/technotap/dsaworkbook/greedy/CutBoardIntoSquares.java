package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;
import java.util.Collections;

public class CutBoardIntoSquares {

    public static void main(String[] args) {
        int m = 6, n = 4;
        Integer[] X = {2, 1, 3, 1, 4};
        Integer[] Y = {4, 1, 2};
        System.out.println(minimumCost(X, Y, m - 1, n - 1));
    }

    private static int minimumCost(Integer[] horizontalCost, Integer[] verticalCost, int m, int n) {
        Arrays.sort(horizontalCost, Collections.reverseOrder());
        Arrays.sort(verticalCost, Collections.reverseOrder());
        int i = 0, j = 0, hCut = 1, vCut = 1, result = 0;
        while (i < m && j < n) {
            if (horizontalCost[i] > verticalCost[j]) {
                result += horizontalCost[i] * vCut;
                hCut++;
                i++;
            } else {
                result += verticalCost[j] * hCut;
                vCut++;
                j++;
            }
        }
        int total = 0;
        while (i < m) total += horizontalCost[i++];
        result += total * vCut;
        total = 0;
        while (j < n) total += verticalCost[j++];
        result += total * hCut;
        return result;
    }
}
