package stackqueue;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumAndMinimumOfK {
    public static void main(String[] args) throws IOException {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        print(arr, arr.length, k);
    }

    private static void print(int[] arr, int n, int k) {
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            while (!minQ.isEmpty() && arr[minQ.peekLast()] > arr[i]) minQ.removeLast();
            while (!maxQ.isEmpty() && arr[maxQ.peekLast()] < arr[i]) maxQ.removeLast();
            minQ.add(i);
            maxQ.add(i);
        }
        for (int i = k; i < n && !minQ.isEmpty() && !maxQ.isEmpty(); i++) {
            sum += arr[minQ.peek()] + arr[maxQ.peek()];
            while (!minQ.isEmpty() && minQ.peekFirst() <= i - k) minQ.remove();
            while (!maxQ.isEmpty() && maxQ.peekFirst() <= i - k) maxQ.remove();
            while (!minQ.isEmpty() && arr[minQ.peekLast()] > arr[i]) minQ.removeLast();
            while (!maxQ.isEmpty() && arr[maxQ.peekLast()] < arr[i]) maxQ.removeLast();
            minQ.add(i);
            maxQ.add(i);
        }
        if (!minQ.isEmpty() && !maxQ.isEmpty())
            sum += arr[minQ.peek()] + arr[maxQ.peek()];
        System.out.println(sum);
    }
}
