package java.stackqueue;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;
        sortStack(stack);
        return stack;
    }

    private static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) stack.push(x);
        else {
            int top = stack.pop();
            sortedInsert(stack, x);
            stack.push(top);
        }
    }
}
