package com.technotap.dsaworkbook.linkedlist;

public class CountTripletsWithSumX {
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
        int X = 15;
        System.out.println(count(head, X));
    }

    private static int count(Node head, int X) {
        if (head == null) return 0;
        int count = 0;
        Node end = head;
        while (end.next != null) end = end.next;
        for (Node i = head; i != null; i = i.next) {
            Node j = i.next;
            Node k = end;
            while (j != null && j.data < k.data) {
                int sum = i.data + j.data + k.data;
                if (sum == X) {
                    count++;
                    j = j.next;
                    k = k.prev;
                } else if (sum < X)
                    j = j.next;
                else
                    k = k.prev;
            }
        }
        return count;
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
