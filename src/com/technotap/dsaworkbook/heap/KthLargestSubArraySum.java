package com.technotap.dsaworkbook.heap;

import java.util.PriorityQueue;

public class KthLargestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {10, -10, 20, -40};
        int k = 6;
        System.out.println(kthLargestSum(arr, arr.length, k));
    }

    private static int kthLargestSum(int[] arr, int n, int k) {
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = preSum[j] - preSum[i - 1];
                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else if (!minHeap.isEmpty() && minHeap.peek() < sum) {
                    minHeap.remove();
                    minHeap.add(sum);
                }
            }
        }
        return minHeap.remove();
    }
}
