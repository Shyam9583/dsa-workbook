package com.technotap.dsaworkbook.heap;

import java.util.PriorityQueue;

public class MedianInAStream {
    private static final PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private static final PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) {
        int[] stream = {5, 15, 1, 3};
        for (int item : stream) {
            insertHeap(item);
            System.out.println(getMedian());
        }
    }

    private static void insertHeap(int x) {
        if (!right.isEmpty() && right.peek() < x) {
            right.add(x);
        } else left.add(x);
        balanceHeaps();
    }

    private static void balanceHeaps() {
        if (left.size() - right.size() > 1) {
            right.add(left.remove());
        } else if (right.size() - left.size() > 1) {
            left.add(right.remove());
        }
    }

    private static double getMedian() {
        if (left.size() > right.size()) return left.peek();
        if (right.size() > left.size()) return right.peek();
        return left.isEmpty() ? 0 : (left.peek() + right.peek()) * 0.5;
    }
}
