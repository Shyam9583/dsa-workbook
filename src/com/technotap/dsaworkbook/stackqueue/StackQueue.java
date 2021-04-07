package com.technotap.dsaworkbook.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    /*The method pop which return the element popped out of the stack*/
    private static int pop() {
        if (!q1.isEmpty()) return q1.remove();
        if (!q2.isEmpty()) return q2.remove();
        return -1;
    }

    /* The method push to push element into the stack */
    private static void push(int a) {
        if (q1.isEmpty()) {
            q1.add(a);
            while (!q2.isEmpty()) q1.add(q2.remove());
        } else {
            q2.add(a);
            while (!q1.isEmpty()) q2.add(q1.remove());
        }
    }
}
