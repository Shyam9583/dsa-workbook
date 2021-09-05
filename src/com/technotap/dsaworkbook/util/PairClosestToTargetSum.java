package com.technotap.dsaworkbook.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairClosestToTargetSum {
    public static void main(String[] args) {
        int[] arr1 = {-1, 3, 8, 2, 9, 5};
        int[] arr2 = {4, 1, 2, 10, 5, 20};
        int targetSum = 24;
        findPairs(arr1, arr2, targetSum).stream().map(Arrays::toString).forEach(System.out::println);
    }

    private static List<int[]> findPairs(int[] arr1, int[] arr2, int targetSum) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = n - 1, ptr = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Entry[] candidates = new Entry[2];

        while (i < m && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(targetSum - sum);

            if (candidates[ptr] == null || candidates[ptr].diff >= diff) {
                candidates[ptr] = new Entry(diff, arr1[i], arr2[j]);
                ptr = 1 - ptr;
            } else if (candidates[ptr] != null && candidates[ptr].diff == diff) {
                ptr = 1 - ptr;
            }

            if (sum < targetSum) i++;
            else j--;
        }

        List<int[]> result = new ArrayList<>();
        for (Entry entry : candidates) {
            if (entry == null) continue;
            result.add(new int[]{entry.num1, entry.num2});
        }

        return result;
    }

    private static class Entry {
        int diff, num1, num2;

        Entry(int diff, int num1, int num2) {
            this.diff = diff;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "diff=" + diff +
                    ", num1=" + num1 +
                    ", num2=" + num2 +
                    '}';
        }
    }
}
