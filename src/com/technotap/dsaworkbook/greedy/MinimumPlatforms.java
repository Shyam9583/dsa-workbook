package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ap = 1, dp = 0, result = 1, need = 1;
        while (ap < n && dp < n) {
            if (arr[ap] < dep[dp]) {
                need++;
                ap++;
            } else {
                need--;
                dp++;
            }
            result = Math.max(result, need);
        }
        return result;
    }
}
