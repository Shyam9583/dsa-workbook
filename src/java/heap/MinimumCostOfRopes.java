package java.heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr, arr.length));
    }

    private static long minCost(long[] arr, int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long result = 0;
        for (long item : arr) heap.add(item);
        while (heap.size() > 1) {
            long sum = heap.remove() + heap.remove();
            result += sum;
            heap.add(sum);
        }
        return result;
    }
}
