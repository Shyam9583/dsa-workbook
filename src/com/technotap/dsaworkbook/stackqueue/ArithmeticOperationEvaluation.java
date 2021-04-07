package com.technotap.dsaworkbook.stackqueue;

import java.util.HashMap;
import java.util.Stack;

public class ArithmeticOperationEvaluation {

    private static HashMap<Character, Integer> precedence;

    public static void main(String[] args) {
        init();
        String expression = "(A+B/C*(D+E)-F)";
        int result = evaluate(expression, 1, 2, 2, 1, 1, 1);
        System.out.println(result);
    }

    private static void init() {
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    private static boolean isVariable(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isBracket(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}';
    }

    private static void handleBracket(char bracket, Stack<Character> stack, StringBuilder postfix) {
        switch (bracket) {
            case '(':
            case '[':
            case '{': {
                stack.push(bracket);
                break;
            }
            case ')':
            case ']':
            case '}': {
                while (!stack.isEmpty()) {
                    if (isBracket(stack.peek())) {
                        stack.pop();
                        break;
                    }
                    postfix.append(stack.pop());
                }
            }
        }
    }

    private static void handleOperator(char operator, Stack<Character> stack, StringBuilder postfix) {
        while (!stack.isEmpty()) {
            char top = stack.peek();
            if (isBracket(top) || precedence.get(top) < precedence.get(operator)) break;
            postfix.append(stack.pop());
        }
        stack.push(operator);
    }

    private static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isVariable(c)) {
                postfix.append(c);
            } else if (isBracket(c)) {
                handleBracket(c, stack, postfix);
            } else {
                handleOperator(c, stack, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static int evaluate(String expression, int... vars) {
        String postfix = infixToPostfix(expression);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, v = 0; i < postfix.length(); i++) {
            if (isVariable(postfix.charAt(i))) {
                stack.push(vars[v++]);
            } else {
                int a = stack.pop(), b = stack.pop();
                int result = calculate(b, a, postfix.charAt(i));
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return b == 0 ? Integer.MAX_VALUE : a / b;
            default:
                return 0;
        }
    }
}
