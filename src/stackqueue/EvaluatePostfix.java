package stackqueue;

import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String s = "123+*8-";
        System.out.println(evaluatePostfix(s));
    }

    private static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) stack.push(c - '0');
            else {
                int b = stack.pop(), a = stack.pop();
                stack.push(calculate(a, b, c));
            }
        }
        return stack.pop();
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/': {
                if (b == 0)
                    throw new ArithmeticException("Dividing by zero");
                return a / b;
            }
            default:
                return 0;
        }
    }
}
