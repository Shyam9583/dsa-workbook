package com.technotap.dsaworkbook.stackqueue;

import java.util.Stack;

public class InsertAtEndOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        insertAtTheEnd(stack, 4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void insertAtTheEnd(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) stack.push(x);
        else {
            int top = stack.pop();
            insertAtTheEnd(stack, x);
            stack.push(top);
        }
    }
}
