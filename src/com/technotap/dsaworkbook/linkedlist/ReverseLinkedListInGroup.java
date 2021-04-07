package com.technotap.dsaworkbook.linkedlist;

public class ReverseLinkedListInGroup {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6, 7, 8};
        Node head = create(arr);
        insert(head, 9);
        insert(head, 10);
        System.out.println(print(head));

        int k = 5;
        head = reverseInGroup(head, k);
        System.out.println(print(head));
    }

    private static Node reverse(Node head, int k, int size) {
        if (size >= k) {
            Node curr = head, prev = null, next = null;
            int count = 0;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (next != null)
                head.next = reverse(next, k, size - k);
            return prev;
        } else {
            return head;
        }
    }

    private static Node reverseInGroup(Node head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        int size = 0;
        for (Node curr = head; curr != null; curr = curr.next) size++;
        return reverse(head, k, size);
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

    private static Node insert(Node head, int data) {
        if (head != null) {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = new Node(data);
        } else {
            head = new Node(data);
        }
        return head;
    }

    private static String print(Node head) {
        if (head == null) return "";
        if (head.next == null) return String.valueOf(head.data);

        Node current = head.next;
        StringBuilder s = new StringBuilder();
        s.append("(").append(head.data).append(")");
        while (current != null) {
            s.append(" -> ").append("(").append(current.data).append(")");
            current = current.next;
        }
        return s.toString();
    }

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}
