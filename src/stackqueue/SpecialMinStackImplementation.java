package stackqueue;

import java.util.EmptyStackException;

public class SpecialMinStackImplementation {
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(8);
        stack.push(10);
        stack.push(6);
        stack.push(3);
        stack.push(5);
        stack.push(13);
        stack.push(15);
        while (!stack.isEmpty()) {
            System.out.println("max : " + stack.getMax() + ", top : " + stack.pop());
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class MinStack {
        private Node top;
        private int min;

        MinStack() {
            this.top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int getMin() {
            if (isEmpty()) throw new EmptyStackException();
            return min;
        }

        public int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        public int pop() {
            if (isEmpty()) throw new EmptyStackException();
            int data = top.data;
            if (data < min) {
                data = min;
                min = 2 * min - top.data;
            }
            top = top.next;
            return data;
        }

        public void push(int data) {
            if (isEmpty()) {
                min = data;
                top = new Node(data);
            } else {
                Node node;
                if (data < min) {
                    node = new Node(2 * data - min);
                    min = data;
                } else {
                    node = new Node(data);
                }
                node.next = top;
                top = node;
            }
        }
    }

    private static class MaxStack {
        private Node top;
        private int max;

        MaxStack() {
            top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int getMax() {
            if (isEmpty()) throw new EmptyStackException();
            return max;
        }

        public int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        public int pop() {
            if (isEmpty()) throw new EmptyStackException();
            int data = top.data;
            if (data > max) {
                data = max;
                max = 2 * max - top.data;
            }
            top = top.next;
            return data;
        }

        public void push(int data) {
            if (isEmpty()) {
                max = data;
                top = new Node(data);
            } else {
                Node node;
                if (data > max) {
                    node = new Node(2 * data - max);
                    max = data;
                } else {
                    node = new Node(data);
                }
                node.next = top;
                top = node;
            }
        }
    }
}
