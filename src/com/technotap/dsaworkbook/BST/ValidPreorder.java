package com.technotap.dsaworkbook.BST;

import java.util.Stack;

public class ValidPreorder {

    public static void main(String[] args) {
        int[] invalidPreorder = {5, 4, 3, 6, 1};
        int[] validPreorder = {5, 4, 3, 6};
        System.out.println(valid(invalidPreorder));
        System.out.println(valid(validPreorder));
    }

    private static boolean valid(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lastRemoved = Integer.MIN_VALUE;
        for (int element : preorder) {
            if (lastRemoved > element)
                return false;
            while (!stack.isEmpty() && element > stack.peek()) {
                lastRemoved = stack.pop(); // removal means we go right
            }
            stack.push(element);
        }
        return true;
    }
}
