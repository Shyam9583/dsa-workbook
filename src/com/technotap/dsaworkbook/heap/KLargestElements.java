package com.technotap.dsaworkbook.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;
        System.out.println(Arrays.toString(kLargest(arr, arr.length, k)));
    }

    private static int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else if (!heap.isEmpty() && heap.peek() < arr[i]) {
                heap.remove();
                heap.add(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.remove();
        }
        return result;
    }
}
