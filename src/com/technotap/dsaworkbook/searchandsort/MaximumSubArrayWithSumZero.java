package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(Arrays.toString(largestSubArray(arr)));
    }

    private static int[] largestSubArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, len = 0;
        for (int sum = 0, i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 && len == 0) {
                start = i;
                len = 1;
            }
            if (sum == 0) {
                start = 0;
                len = i + 1;
            }
            if (map.containsKey(sum)) {
                int prev = map.get(sum);
                if (i - prev > len) {
                    start = prev + 1;
                    len = i - prev;
                }
            }
            map.putIfAbsent(sum, i);
        }
        return Arrays.copyOfRange(arr, start, start + len);
    }
}
