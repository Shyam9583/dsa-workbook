package java.greedy;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        System.out.println(minimumCost(arr, arr.length));
    }

    private static long minimumCost(long[] arr, int n) {
        if (n == 1) return 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long totalCost = 0;
        for (long item : arr) heap.add(item);
        while (heap.size() > 1) {
            long cost = heap.poll();
            if (!heap.isEmpty())
                cost += heap.poll();
            totalCost += cost;
            heap.add(cost);
        }
        return totalCost;
    }
}
