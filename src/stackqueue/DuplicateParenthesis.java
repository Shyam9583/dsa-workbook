package stackqueue;

import java.util.HashSet;
import java.util.Stack;

public class DuplicateParenthesis {
    public static void main(String[] args) {
        String s = "(a+(b)/c)";
        System.out.println(removeDuplicate(s));
    }

    private static boolean containsDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.peek() == '(') return true;
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '(') break;
                }
            } else stack.push(s.charAt(i));
        }
        return false;
    }

    private static String removeDuplicate(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        HashSet<Integer> indices = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == ')') {
                if (arr[stack.peek()] == '(') {
                    indices.add(i);
                    indices.add(stack.pop());
                } else {
                    int cnt = 0;
                    while (!stack.isEmpty()) {
                        int top = stack.pop();
                        if (arr[top] == '(') {
                            if (cnt == 1) {
                                indices.add(i);
                                indices.add(top);
                            }
                            break;
                        }
                        cnt++;
                    }
                }
            } else stack.push(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!indices.contains(i)) builder.append(arr[i]);
        }
        return builder.toString();
    }
}
