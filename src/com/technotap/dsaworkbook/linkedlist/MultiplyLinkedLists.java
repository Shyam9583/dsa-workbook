package com.technotap.dsaworkbook.linkedlist;

public class MultiplyLinkedLists {

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
        int[] arr1 = {7, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 0, 9, 3, 6, 0, 6, 2, 6, 1, 8, 7, 9, 2, 0, 2, 3, 7, 5, 9, 2, 2, 8, 9, 7, 3, 6, 1, 2, 9, 3, 1, 9, 4, 7, 8, 4, 5, 0, 3, 6, 1, 0, 6, 3, 2, 0, 6, 1, 5, 5, 4, 7, 6, 5, 6, 9, 3, 7, 4, 5, 2, 5, 4, 7, 4, 4, 3, 0, 7, 8, 6, 8, 8};
        int[] arr2 = {4, 1, 4, 9, 2, 0, 6, 8, 9, 2, 6, 6, 4, 9, 5, 0, 4, 8, 7, 1, 7, 2, 7, 2, 2, 6, 1, 0, 6, 1, 5, 9, 4, 9, 0, 9, 1, 7, 7, 1, 1, 5, 9, 7, 7, 6, 7, 3, 6, 5, 6, 3, 9, 4, 8, 1, 2, 9, 3, 9, 0, 8, 8, 5, 0, 9, 6, 3, 8, 5, 6, 1, 1, 5, 9, 8, 4, 8, 1, 0, 3, 0, 4, 4, 4};
        Node L1 = create(arr1);
        Node L2 = create(arr2);
        long result = multiply(L1, L2);
        System.out.println(result);
    }

    private static long multiply(Node L1, Node L2) {
        if (L1 == null || L2 == null) return 0;
        Node temp = new Node(-1);
        Node cursor = temp;
        L1 = reverse(L1);
        L2 = reverse(L2);
        for (Node i = L2; i != null; i = i.next) {
            int carry = 0;
            Node pointer = cursor;
            for (Node j = L1; j != null; j = j.next) {
                int sum = carry + (i.data * j.data);
                if (pointer.next == null) {
                    pointer.next = new Node(sum % 10);
                    carry = sum / 10;
                } else {
                    int digit = pointer.next.data;
                    pointer.next.data = (pointer.next.data + sum) % 10;
                    carry = (digit + sum) / 10;
                }
                pointer = pointer.next;
            }
            if (carry != 0)
                pointer.next = new Node(carry);
            cursor = cursor.next;
        }
        return getValue(temp.next);
    }

    private static long getValue(Node head) {
        long base = (long) 10e9 + 7;
        long result = 0, multiple = 1;
        while (head != null) {
            result = (result + head.data * multiple) % base;
            multiple = (multiple * 10) % base;
            head = head.next;
        }
        return result % base;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        while (head != null) {
            Node next = head.next;
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
