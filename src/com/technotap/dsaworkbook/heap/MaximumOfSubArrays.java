package com.technotap.dsaworkbook.heap;

import java.util.PriorityQueue;

public class MaximumOfSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        maxOfSubArrays(arr, arr.length, k);
    }

    private static void maxOfSubArrays(int[] arr, int n, int k) {
        PriorityQueue<Entry> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(new Entry(i, arr[i]));
        }
        for (int i = k; i < n && !heap.isEmpty(); i++) {
            Entry max = heap.peek();
            System.out.print(max.val + " ");
            while (!heap.isEmpty() && heap.peek().idx <= i - k) heap.remove();
            heap.add(new Entry(i, arr[i]));
        }
        System.out.println(heap.remove().val);
    }

    private static class Entry implements Comparable<Entry> {
        int idx, val;

        Entry(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Entry o) {
            if (val == o.val) return idx - o.idx;
            return o.val - val;
        }
    }
}
