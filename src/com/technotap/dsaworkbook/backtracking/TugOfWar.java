package com.technotap.dsaworkbook.backtracking;

import java.util.ArrayList;
import java.util.List;

public class TugOfWar {
    public static void main(String[] args) {
        int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        System.out.println(minDiff(arr));
    }

    private static String minDiff(int[] arr) {
        int[] minDiff = {Integer.MAX_VALUE};
        String[] result = {""};
        minDiffUtil(0, arr, new ArrayList<>(), new ArrayList<>(), 0, 0, minDiff, result);
        return result[0];
    }

    private static void minDiffUtil(int idx, int[] arr, List<Integer> first, List<Integer> second, int sum1, int sum2, int[] minDiff, String[] result) {
        if (idx == arr.length) {
            int diff = Math.abs(sum1 - sum2);
            if (minDiff[0] > diff) {
                minDiff[0] = diff;
                result[0] = first + ", " + second + " ||| diff = " + minDiff[0];
            }
            return;
        }
        if (first.size() < (arr.length + 1) / 2) {
            first.add(arr[idx]);
            minDiffUtil(idx + 1, arr, first, second, sum1 + arr[idx], sum2, minDiff, result);
            first.remove(first.size() - 1);
        }

        if (second.size() < (arr.length - 1) / 2) {
            second.add(arr[idx]);
            minDiffUtil(idx + 1, arr, first, second, sum1, sum2 + arr[idx], minDiff, result);
            second.remove(second.size() - 1);
        }
    }
}
