package com.technotap.dsaworkbook.linkedlist;

public class SplitCircularLinkedList {

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
        int[] arr = {1, 5, 7};
        Node list = create(arr, true);
        circular_LinkedList circular_linkedList = new circular_LinkedList(list);
        System.out.println(printLoop(circular_linkedList.head, 10));
        splitEfficient(circular_linkedList);
        System.out.println(printLoop(circular_linkedList.head1, 10));
        System.out.println(printLoop(circular_linkedList.head2, 10));
    }

    private static void split(circular_LinkedList list) {
        if (list.head != null) {
            int length = 1;
            Node end = list.head.next;
            while (end.next != list.head) {
                length++;
                end = end.next;
            }
            Node middle = list.head;
            for (int i = 0; i < length / 2; i++) {
                middle = middle.next;
            }
            list.head1 = list.head;
            list.head2 = middle.next;
            end.next = middle.next;
            middle.next = list.head;
        }
    }

    private static void splitEfficient(circular_LinkedList list) {
        if (list.head != null) {
            int ctr = 0;
            Node end = list.head, middle = list.head;
            while (end.next != list.head) {
                if ((ctr & 1) == 1)
                    middle = middle.next;
                ctr++;
                end = end.next;
            }
            list.head1 = list.head;
            list.head2 = middle.next;
            end.next = middle.next;
            middle.next = list.head;
        }
    }

    private static class circular_LinkedList {
        Node head, head1, head2;

        circular_LinkedList(Node head) {
            this.head = head;
            this.head1 = null;
            this.head2 = null;
        }
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
