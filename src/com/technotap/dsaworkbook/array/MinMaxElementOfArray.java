package com.technotap.dsaworkbook.array;

import java.util.Arrays;
import java.util.Random;

public class MinMaxElementOfArray {
    public static void main(String[] args) {
        int[] arr = new Random().ints(0, 100).limit(10).toArray();
        System.out.println(Arrays.toString(arr));
        printMinMax(arr);
    }

    private static void printMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
