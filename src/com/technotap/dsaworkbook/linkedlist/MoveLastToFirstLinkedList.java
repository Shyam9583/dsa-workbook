package com.technotap.dsaworkbook.linkedlist;

public class MoveLastToFirstLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = create(arr);
        System.out.println(head);
        head = moveLastToFirst(head);
        System.out.println(head);
    }

    private static Node moveLastToFirst(Node head) {
        if (head == null || head.next == null) return head;
        Node curr = head, prev = null, next = head.next;
        while (next != null) {
            prev = curr;
            curr = next;
            next = next.next;
        }
        prev.next = null;
        curr.next = head;
        return curr;
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
