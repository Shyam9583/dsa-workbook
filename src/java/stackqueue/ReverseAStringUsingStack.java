package java.stackqueue;

import java.util.Stack;

public class ReverseAStringUsingStack {
    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        System.out.println(reverse(str));
    }

    private static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        return builder.toString();
    }
}
