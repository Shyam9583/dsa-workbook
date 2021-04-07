package com.technotap.dsaworkbook.linkedlist;

public class DeleteNodeHavingGreaterValueOnRight {

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        Node head = create(arr);
        System.out.println(head);
        head = trim(head);
        System.out.println(head);
    }

    private static Node trim(Node head) {
        if (head == null || head.next == null) return head;
        head = reverse(head);
        Node curr = head;
        int max = Integer.MIN_VALUE;
        while (curr != null) {
            if (max < curr.data)
                max = curr.data;
            curr.next = next(curr.next, max);
            curr = curr.next;
        }
        return reverse(head);
    }

    private static Node next(Node head, int max) {
        if (head == null) return null;
        return head.data < max ? next(head.next, max) : head;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node next, prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
