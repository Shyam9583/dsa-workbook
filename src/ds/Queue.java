package ds;

import sun.plugin.dom.exception.InvalidAccessException;

public class Queue {

    // remove from head
    private Node head;
    // add to the tail
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (head == null)
            throw new EmptyQueueException();
        else
            return head.data;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null)
            head = node;
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        return data;
    }

    public static class EmptyQueueException extends InvalidAccessException {
        public EmptyQueueException() {
            super("The Queue is Empty");
        }
    }

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

}
