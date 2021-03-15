package heap;

import java.util.PriorityQueue;

public class KthSmallestAndLargest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, arr.length, k));
        System.out.println(kthLargest(arr, arr.length, k));
    }

    private static int kthSmallest(int[] arr, int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(arr[i]);
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > arr[i]) {
                maxHeap.remove();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.remove();
    }

    private static int kthLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (minHeap.size() < k) {
                minHeap.add(arr[i]);
            } else if (!minHeap.isEmpty() && minHeap.peek() < arr[i]) {
                minHeap.remove();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.remove();
    }
}
