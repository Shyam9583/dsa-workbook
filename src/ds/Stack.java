package ds;

import java.util.EmptyStackException;

public class Stack {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();
        else
            return top.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (top == null)
            throw new EmptyStackException();
        int data = top.data;
        top = top.next;
        return data;
    }

    private static class Node {
        private final int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
