package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MobileNumericKeypad {
    public static void main(String[] args) {
        int N = 3;
        System.out.println(getCount(N));
    }

    private static long getCount(int N) {
        long[] prev = new long[10], curr = new long[10], temp;
        Map<Integer, int[]> map = getMapping();
        Arrays.fill(curr, 1);
        for (int i = 2; i <= N; i++) {
            temp = curr;
            curr = prev;
            prev = temp;
            for (int j = 0; j < 10; j++) {
                curr[j] = 0;
                for (int k : map.get(j)) {
                    curr[j] += prev[k];
                }
            }
        }
        return Arrays.stream(curr).sum();
    }

    private static Map<Integer, int[]> getMapping() {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{0, 8});
        map.put(1, new int[]{1, 2, 4});
        map.put(2, new int[]{1, 2, 3, 5});
        map.put(3, new int[]{2, 3, 6});
        map.put(4, new int[]{1, 4, 5, 7});
        map.put(5, new int[]{2, 4, 5, 6, 8});
        map.put(6, new int[]{3, 5, 6, 9});
        map.put(7, new int[]{4, 7, 8});
        map.put(8, new int[]{5, 7, 8, 9, 0});
        map.put(9, new int[]{6, 8, 9});
        return map;
    }
}
