package com.technotap.dsaworkbook.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerOfK {

    public static void main(String[] args) throws IOException {
        int[] arr;
        int n, k;
        Queue<Node> deque = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; t++) {
            deque.clear();
            n = Integer.parseInt(reader.readLine());
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(n).mapToInt(Integer::parseInt).toArray();
            k = Integer.parseInt(reader.readLine());
            print(arr, n, k, deque);
        }
    }

    private static void print(int[] arr, int n, int k, Queue<Node> deque) {
        int size = 0;
        for (int i = 0; i < n; ) {
            if (size == k) {
                if (deque.isEmpty()) System.out.print("0 ");
                else if (deque.peek().idx < i - k) {
                    deque.remove();
                    continue;
                } else System.out.print(deque.peek().val + " ");
            } else size++;
            if (arr[i] < 0) deque.add(new Node(arr[i], i));
            i++;
        }
        while (!deque.isEmpty() && deque.peek().idx < n - k) deque.remove();
        System.out.println(deque.isEmpty() ? 0 : deque.peek().val);
    }

    private static class Node {
        int val, idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
