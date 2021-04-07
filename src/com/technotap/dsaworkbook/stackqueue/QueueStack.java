package com.technotap.dsaworkbook.stackqueue;

import java.util.Stack;

public class QueueStack {

    private static final Stack<Integer> s1 = new Stack<>();
    private static final Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        push(2);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
    }

    private static void push(int x) {
        if (s1.isEmpty()) {
            s1.add(x);
            reverseInsert(s2, s1);
        } else {
            s2.add(x);
            reverseInsert(s1, s2);
        }
    }

    private static int pop() {
        if (!s1.isEmpty()) return s1.pop();
        if (!s2.isEmpty()) return s2.pop();
        return -1;
    }

    private static void reverseInsert(Stack<Integer> s1, Stack<Integer> s2) {
        if (!s1.isEmpty()) {
            int top = s1.pop();
            reverseInsert(s1, s2);
            s2.push(top);
        }
    }
}
