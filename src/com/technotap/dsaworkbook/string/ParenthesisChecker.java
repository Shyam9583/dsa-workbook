package com.technotap.dsaworkbook.string;

import java.util.EmptyStackException;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String expression = "[(])";
        System.out.println(isPar(expression));
    }

    private static boolean isPar(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            try {
                switch (s.charAt(i)) {
                    case '{':
                    case '(':
                    case '[': {
                        stack.push(s.charAt(i));
                        break;
                    }
                    case ']': {
                        if (stack.peek() == '[')
                            stack.pop();
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    }
                    case ')': {
                        if (stack.peek() == '(')
                            stack.pop();
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    }
                    case '}': {
                        if (stack.peek() == '{')
                            stack.pop();
                        else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    }
                }
            } catch (EmptyStackException ignored) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
