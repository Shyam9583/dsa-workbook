package com.technotap.dsaworkbook.linkedlist;

public class FlattenTheLinkedList {
    private static Node createList(int[][] list) {
        Node head = new Node(list[0][0]);
        head.bottom = createSublist(list[0]);
        Node curr = head;
        for (int i = 1; i < list.length; i++) {
            curr.next = new Node(list[i][0]);
            curr = curr.next;
            curr.bottom = createSublist(list[i]);
        }
        return head;
    }

    private static Node createSublist(int[] arr) {
        if (arr.length < 2) return null;
        Node head = new Node(arr[1]);
        Node curr = head;
        for (int i = 2; i < arr.length; i++) {
            curr.bottom = new Node(arr[i]);
            curr = curr.bottom;
        }
        return head;
    }

    private static void printList(Node head) {
        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                System.out.print(col.data + " ");
                col = col.bottom;
            }
            System.out.println();
            row = row.next;
        }
    }

    private static void printFlattenedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.bottom;
        }
    }

    public static void main(String[] args) {
        int[][] list = {
                {5, 7, 8, 30},
                {10, 20},
                {19, 22, 50},
                {28, 35, 40, 45}
        };
        Node head = createList(list);
//        printList(head);
        head = flatten(head);
        printFlattenedList(head);
    }

    private static Node flatten(Node head) {
        if (head == null || head.next == null) return head;
        Node curr = head;
        Node next = head.next;
        while (next != null) {
            Node subHead = new Node(-1);
            Node temp = subHead;
            Node left = curr, right = next;
            while (left != null && right != null) {
                if (left.data > right.data) {
                    temp.bottom = right;
                    temp = temp.bottom;
                    right = right.bottom;
                } else {
                    temp.bottom = left;
                    temp = temp.bottom;
                    left = left.bottom;
                }
            }
            while (left != null) {
                temp.bottom = left;
                temp = temp.bottom;
                left = left.bottom;
            }
            while (right != null) {
                temp.bottom = right;
                temp = temp.bottom;
                right = right.bottom;
            }
            curr = subHead.bottom;
            next = next.next;
        }
        curr.next = null;
        return curr;
    }

    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
