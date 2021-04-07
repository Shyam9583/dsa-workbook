package com.technotap.dsaworkbook.linkedlist;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1, 7, 8, 7, 8, 9, 10, 2, 2};
        Node head = create(arr);
        System.out.println(head);
        Node sorted = sort(head);
        System.out.println(sorted);
    }

    private static Node sort(Node node) {
        if (node == null || node.next == null) return node;
        Node middle = findMiddle(node);
        Node next = middle.next;
        middle.next = null;
        Node first = sort(node);
        Node second = sort(next);
        return merge(first, second);
    }

    private static Node merge(Node first, Node second) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node left = first, right = second;
        while (left != null && right != null) {
            if (left.data > right.data) {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            } else {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }
        }
        while (left != null) {
            curr.next = left;
            curr = curr.next;
            left = left.next;
        }
        while (right != null) {
            curr.next = right;
            curr = curr.next;
            right = right.next;
        }
        return dummy.next;
    }

    private static Node findMiddle(Node head) {
        if (head == null || head.next == null) return head;
        int counter = 0;
        Node middle = head;
        while (head.next != null) {
            if ((counter & 1) == 1)
                middle = middle.next;
            counter++;
            head = head.next;
        }
        return middle;
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
