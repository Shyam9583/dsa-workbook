package stackqueue;

import java.util.EmptyStackException;

public class StackWithMiddleFunctionality {

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();
        for (int i = 1; i < 7; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.findMiddle());
            stack.deleteMiddle();
        }
    }

    private static class SpecialStack {
        private Node top, mid;
        private int size;

        SpecialStack() {
            top = mid = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        public void push(int data) {
            Node node = new Node(data);
            if (isEmpty()) {
                top = mid = node;
                size++;
            } else {
                top.prev = node;
                node.next = top;
                top = node;
                if ((++size & 1) == 0)
                    mid = mid.prev;
            }
        }

        public int pop() {
            if (isEmpty()) throw new EmptyStackException();
            int data = top.data;
            top = top.next;
            if ((--size & 1) == 1)
                mid = mid.next;
            return data;
        }

        public int findMiddle() {
            if (isEmpty()) throw new EmptyStackException();
            return mid.data;
        }

        public void deleteMiddle() {
            if (isEmpty()) throw new EmptyStackException();
            if (mid == top) {
                top = mid = mid.next;
                size--;
            } else if (mid.prev != null) {
                mid.prev.next = mid.next;
                if (mid.next != null)
                    mid.next.prev = mid.prev;
                if ((--size & 1) == 1)
                    mid = mid.next;
                else
                    mid = mid.prev;
            }
        }

        private static class Node {
            int data;
            Node prev, next;

            Node(int data) {
                this.data = data;
                this.prev = this.next = null;
            }
        }
    }
}
