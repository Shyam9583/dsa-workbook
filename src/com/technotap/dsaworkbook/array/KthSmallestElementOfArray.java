package com.technotap.dsaworkbook.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementOfArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }

    private static int kthSmallest(int[] arr, int k) {
        if (k > arr.length) k %= arr.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : arr) {
            if (heap.size() == k) {
                if (!heap.isEmpty() && heap.peek() > val) {
                    heap.remove();
                    heap.add(val);
                }
            } else {
                heap.add(val);
            }
        }
        return heap.remove();
    }
}
