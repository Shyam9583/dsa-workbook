package com.technotap.dsaworkbook.linkedlist;

import java.util.PriorityQueue;

public class SortNearlySortedLinkedList {

    private static Node createList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head, prev;
        for (int i = 1; i < arr.length; i++) {
            prev = curr;
            curr.next = new Node(arr[i]);
            curr = curr.next;
            curr.prev = prev;
        }
        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != null);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 12, 56, 8};
        Node head = createList(arr);
        printList(head);
        int k = 2;
        sort(head, k);
        printList(head);
    }

    private static void sort(Node head, int k) {
        if (head == null || head.next == null) return;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Node curr = head, end = head.next;
        heap.add(curr.data);
        for (int i = 0; i < k && end != null; i++) {
            heap.add(end.data);
            end = end.next;
        }
        while (end != null && !heap.isEmpty()) {
            curr.data = heap.poll();
            curr = curr.next;
            heap.add(end.data);
            end = end.next;
        }
        while (!heap.isEmpty()) {
            curr.data = heap.poll();
            curr = curr.next;
        }
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
