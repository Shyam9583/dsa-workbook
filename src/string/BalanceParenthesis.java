package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int tests = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
        for (int t = 0; t < tests; t++) {
            input = bufferedReader.readLine().trim();
            System.out.println(changesNeeded(input));
        }
    }

    private static int changesNeeded(String expression) {
        if (expression.length() % 2 == 1)
            return -1;

        Stack<Character> stack = new Stack<>();
        int m = 0, n = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{')
                stack.push('{');
            else {
                try {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(expression.charAt(i));
                    }
                } catch (EmptyStackException ignored) {
                    stack.push(expression.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '}')
                m++;
            else
                n++;
        }

        return (int) (Math.ceil(m / 2.0) + Math.ceil(n / 2.0));
    }
}
