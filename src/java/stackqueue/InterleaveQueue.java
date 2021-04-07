package java.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 11; i < 21; i++) {
            q.add(i);
        }
        System.out.println(interleave(q));
    }

    private static Queue<Integer> interleave(Queue<Integer> q) {
        int half = q.size() / 2;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < half; i++) {
            stack.push(q.remove());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        for (int i = 0; i < half; i++) {
            q.add(q.remove());
        }
        for (int i = 0; i < half; i++) {
            stack.push(q.remove());
        }
        for (int i = 0; i < half; i++) {
            q.add(stack.pop());
            q.add(q.remove());
        }
        return q;
    }
}
