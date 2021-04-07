package com.technotap.dsaworkbook.linkedlist;

public class FindPairWithSumInDoublyLinkedList {
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

    private static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != null);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9};
        Node head = createList(arr);
        int sum = 7;
        printSumPair(head, sum);
    }

    private static void printSumPair(Node head, int sum) {
        if (head == null) return;
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        Node left = head, right = end;
        while (left.data < right.data) {
            int currentSum = left.data + right.data;
            if (currentSum == sum) {
                System.out.println("(" + left.data + ", " + right.data + ")");
                left = left.next;
                right = right.prev;
            } else if (currentSum < sum)
                left = left.next;
            else
                right = right.prev;
        }
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
