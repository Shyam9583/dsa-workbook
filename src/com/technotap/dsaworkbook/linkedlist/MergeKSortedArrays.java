package com.technotap.dsaworkbook.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static Node[] createLists(int[][] arr) {
        Node[] lists = new Node[arr.length];
        for (int i = 0; i < arr.length; i++)
            lists[i] = create(arr[i]);
        return lists;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 3}, {4, 5}, {5, 6}, {7, 8}};
        Node[] lists = createLists(arrays);
        Node result = mergeKLists(lists, lists.length);
        System.out.println(result);
    }

    private static Node mergeKLists(Node[] lists, int N) {
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];

        Node result = new Node(-1);
        Node curr = result;

        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.data));

        heap.addAll(Arrays.asList(lists));

        while (heap.size() > 0) {
            Node min = heap.poll();
            curr.next = min;
            if (min.next != null)
                heap.add(min.next);
            curr = curr.next;
        }

        return result.next;
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
            s.append("(").append(data).append(")");
            while (current != null) {
                s.append(" -> ").append("(").append(current.data).append(")");
                current = current.next;
            }
            return s.toString();
        }

    }

}
