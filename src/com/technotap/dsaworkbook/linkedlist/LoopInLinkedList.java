package com.technotap.dsaworkbook.linkedlist;


public class LoopInLinkedList {

    public static void main(String[] args) {

    }

    private static boolean detectLoop(Node head) {
        if (head == null || head.next == null)
            return false;

        Node hare = head, turtle = head;
        int counter = 0;

        while (hare != null && turtle != null) {
            if (counter > 0 && turtle == hare) {
                return true;
            }
            turtle = turtle.next;
            hare = hare.next;
            if (hare == null)
                return false;
            hare = hare.next;
            counter++;
        }

        return false;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
