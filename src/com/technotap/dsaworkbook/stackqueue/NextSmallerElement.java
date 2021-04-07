package com.technotap.dsaworkbook.stackqueue;

import com.technotap.dsaworkbook.ds.Stack;

import java.util.Arrays;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {13, 7, 6, 12};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }

    private static int[] nextSmallerElement(int[] arr) {
        Stack stack = new Stack();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                result[stack.pop()] = arr[i];
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
