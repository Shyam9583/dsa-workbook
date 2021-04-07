package com.technotap.dsaworkbook.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SegregateEvenOddsInLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(N).mapToInt(Integer::parseInt).toArray();
            System.out.println(segregate(arr, N));
        }
    }

    private static Node segregate(int[] arr, int N) {
        Node even = new Node(-1), odd = new Node(-1);
        Node evenPtr = even, oddPtr = odd;
        for (int item : arr) {
            if ((item & 1) == 0) {
                evenPtr.next = new Node(item);
                evenPtr = evenPtr.next;
            } else {
                oddPtr.next = new Node(item);
                oddPtr = oddPtr.next;
            }
        }
        evenPtr.next = odd.next;
        return even.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(data);
            Node current = next;
            StringBuilder s = new StringBuilder();
            s.append(data);
            while (current != null) {
                s.append(" ").append(current.data);
                current = current.next;
            }
            return s.toString();
        }

    }
}
