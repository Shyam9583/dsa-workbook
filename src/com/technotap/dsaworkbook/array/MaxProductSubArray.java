package com.technotap.dsaworkbook.array;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
        boolean noPositive = true;
        int maxHere = 1, minHere = 1, maxSoFar = 0;
        for (int item : arr) {
            if (item > 0) {
                maxHere *= item;
                minHere = Math.min(minHere * item, 1);
                noPositive = false;
            } else if (item == 0) {
                maxHere = minHere = 1;
            } else {
                int temp = maxHere;
                maxHere = Math.max(minHere * item, 1);
                minHere = temp * item;
            }
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        return noPositive ? 0 : maxSoFar;
    }
}
