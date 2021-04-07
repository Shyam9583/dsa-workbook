package java.stackqueue;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverse(stack);
            insertAtEnd(stack, x);
        }
    }

    private static void insertAtEnd(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) stack.push(x);
        else {
            int top = stack.pop();
            insertAtEnd(stack, x);
            stack.push(top);
        }
    }
}
