package com.technotap.dsaworkbook.linkedlist;

public class DeleteLoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int from = arr.length - 1, to = 5, nIterations = 10;

        Node head = create(arr);

        createLoop(head, from, to);

        System.out.println(printLoop(head, nIterations));

        deleteLoop(head);

        System.out.println(head);
    }

    private static void deleteLoop(Node head) {
        Node loopNode = detectLoop(head);
        if (loopNode != null) {
            int length = loopLength(loopNode);
            Node first = head;
            Node second = getNode(head, length);
            do {
                first = first.next;
                second = second.next;
            } while (first != null && second != null && first != second);
            getNode(first, length).next = null;
        }
    }

    private static void createLoop(Node head, int from, int to) {
        Node loopStart = getNode(head, from);
        loopStart.next = getNode(head, to);
    }

    private static Node detectLoop(Node head) {
        Node hare = head, turtle = head;
        do {
            turtle = turtle.next;
            hare = hare.next;
            if (hare != null) {
                hare = hare.next;
            }
        } while (hare != null && turtle != null && hare != turtle);
        return hare;
    }

    private static int loopLength(Node head) {
        int length = 0;
        Node current = head;
        do {
            current = current.next;
            length++;
        } while (current != null && current != head);
        return length;
    }

    private static Node getNode(Node head, int index) {
        int count = 0;
        Node current = head;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current;
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
