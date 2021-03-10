package stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < 6; i++) stack.push(i);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static class Stack<T> {
        Deque<T> q;

        Stack() {
            q = new LinkedList<>();
        }

        boolean isEmpty() {
            return q.isEmpty();
        }

        void push(T data) {
            q.addLast(data);
        }

        T pop() {
            return q.removeLast();
        }
    }
}
