package com.technotap.dsaworkbook.linkedlist;

public class DeleteFromRoundLinkedList {

    private static String printLoop(Node head, int nIterations) {
        if (head == null) return "";
        if (head.next == null) return String.valueOf(head.data);

        Node current = head.next;
        StringBuilder s = new StringBuilder();
        s.append("(").append(head.data).append(")");
        int count = 0;
        while (current != null && count < nIterations) {
            s.append(" -> ").append("(").append(current.data).append(")");
            current = current.next;
            count++;
        }
        return s.toString();
    }

    private static Node create(int[] arr, boolean makeCircular) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        if (makeCircular)
            curr.next = head;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10};
        Node head = create(arr, true);
        int nIterations = 10, key = 10;
        System.out.println(printLoop(head, nIterations));
        head = delete(head, key);
        System.out.println(printLoop(head, nIterations));
    }

    private static Node delete(Node head, int key) {
        if (head != null) {
            Node curr = head, prev;
            if (curr.data == key) {
                do {
                    prev = curr;
                    curr = curr.next;
                } while (curr != head);
                prev.next = head.next;
            } else {
                do {
                    prev = curr;
                    curr = curr.next;
                } while (curr != head && curr.data != key);
                prev.next = curr.next;
            }
            return prev.next;
        }
        return null;
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
