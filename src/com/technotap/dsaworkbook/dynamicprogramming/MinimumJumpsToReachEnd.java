package com.technotap.dsaworkbook.dynamicprogramming;

public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 3};
        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int jumps = 1, steps = arr[0], maxReachable = arr[0];
        if (arr.length == 1) return 0;
        if (arr[0] == 0) return -1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps;
            maxReachable = Math.max(maxReachable, i + arr[i]);
            if (--steps == 0) {
                if (maxReachable <= i) return -1;
                steps = maxReachable - i;
            }
        }
        return jumps;
    }
}
