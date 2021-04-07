package com.technotap.dsaworkbook.searchandsort;

import java.util.HashMap;

public class FindSubArraysWithSumZero {
    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(findSubArray(arr, arr.length));
    }

    public static int findSubArray(int[] arr, int n) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            sum += el;
            if (sum == 0)
                count++;
            if (!map.containsKey(sum))
                map.put(sum, 1);
            else {
                int value = map.get(sum);
                count += value;
                map.replace(sum, value + 1);
            }
        }
        return count;
    }
}
