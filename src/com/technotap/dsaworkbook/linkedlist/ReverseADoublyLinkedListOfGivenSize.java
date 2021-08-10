package com.technotap.dsaworkbook.linkedlist;

public class ReverseADoublyLinkedListOfGivenSize {

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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createList(arr);
        System.out.println(head);
        head = reverseWithSizeK(head, 3);
        System.out.println(head);
    }

    private static Node reverseWithSizeK(Node head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        Node curr = head, newHead = null, next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            newHead = push(newHead, curr);
            curr = next;
            count++;
        }
        if (count != k) {
            curr = head;
            while (curr != null && count-- > 0) {
                Node prev = curr.prev;
                curr.prev = curr.next;
                curr.next = prev;
                curr = prev;
            }
            return head;
        }
        if (next != null) {
            head.next = reverseWithSizeK(next, k);
            head.next.prev = head;
        }
        return newHead;
    }

    private static Node push(Node head, Node newNode) {
        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        return newNode;
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(data);
            Node current = next;
            StringBuilder s = new StringBuilder();
            s.append("(").append(data).append(")");
            while (current != null) {
                s.append(" <-> ").append("(").append(current.data).append(")");
                current = current.next;
            }
            return s.toString();
        }
    }

}
