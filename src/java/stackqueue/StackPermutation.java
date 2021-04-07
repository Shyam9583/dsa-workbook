package java.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutation {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q2.add(2);
        q2.add(1);
        q2.add(3);
        System.out.println(isPermuted(q1, q2));
    }

    private static boolean isPermuted(Queue<Integer> input, Queue<Integer> output) {
        if (input.size() != output.size()) return false;
        Stack<Integer> stack = new Stack<>();
        while (!input.isEmpty() && !output.isEmpty()) {
            if (stack.isEmpty() || !stack.peek().equals(output.peek())) {
                stack.push(input.remove());
            } else {
                stack.pop();
                output.remove();
            }
        }
        while (!output.isEmpty()) {
            if (stack.peek().equals(output.peek()))
                stack.pop();
            output.remove();
        }
        return stack.isEmpty();
    }
}
