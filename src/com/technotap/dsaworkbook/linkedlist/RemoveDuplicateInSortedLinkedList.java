package com.technotap.dsaworkbook.linkedlist;

public class RemoveDuplicateInSortedLinkedList {

    public static void main(String[] args) {
        int[] list = {1, 1, 1, 2, 2, 4, 5, 5};
        Node head = create(list);
        System.out.println(head);
        head = removeDuplicates(head);
        System.out.println(head);
    }

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static Node removeDuplicates(Node head) {
        if (head == null) return null;
        Node previous = head;
        while (previous != null) {
            Node current = previous.next;
            while (current != null && current.data == previous.data) {
                current = current.next;
            }
            previous.next = current;
            previous = current;
        }
        return head;
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
