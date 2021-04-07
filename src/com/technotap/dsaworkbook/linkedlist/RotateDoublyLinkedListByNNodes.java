package com.technotap.dsaworkbook.linkedlist;

public class RotateDoublyLinkedListByNNodes {

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
        int[] arr = {1, 2, 3, 4};
        int N = 2;
        Node head = createList(arr);
        printList(head);
        head = rotate(head, N);
        printList(head);
        N = 3;
        head = rotate(head, N);
        printList(head);
    }

    private static Node rotate(Node head, int N) {
        if (head == null || head.next == null || N == 0) return head;
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        int rotations = N % length;
        head.prev = tail;
        tail.next = head;
        Node newHead = head, newTail = tail;
        for (int i = 1; i <= rotations; i++) {
            newTail = newHead;
            newHead = newHead.next;
        }
        newHead.prev = null;
        newTail.next = null;
        return newHead;
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
