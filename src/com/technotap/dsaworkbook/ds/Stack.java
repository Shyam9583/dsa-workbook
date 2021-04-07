package com.technotap.dsaworkbook.ds;

import java.util.EmptyStackException;

public class Stack {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        int data = top.data;
        top = top.next;
        return data;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
