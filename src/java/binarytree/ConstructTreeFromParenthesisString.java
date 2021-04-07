package java.binarytree;

import java.util.Stack;

public class ConstructTreeFromParenthesisString {

    private static void printPreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        String string = "4(2(3)(1))(6(5))";
        Node root = createTree(string);
        printPreOrder(root);
    }

    private static Node createTree(String string) {
        Stack<Character> stack = new Stack<>();
        return create(string, stack);
    }

    private static Node create(String string, Stack<Character> stack) {
        if (string.isEmpty()) return null;
        stack.clear();
        Node root = new Node(Integer.parseInt(String.valueOf(string.charAt(0))));
        if (string.length() > 2) {
            int endBracketIndex = 1;
            stack.push(string.charAt(endBracketIndex++));
            while (!stack.isEmpty()) {
                switch (string.charAt(endBracketIndex++)) {
                    case '(': {
                        stack.push('(');
                        break;
                    }
                    case ')': {
                        if (stack.peek() == '(')
                            stack.pop();
                        break;
                    }
                    default:
                        break;
                }
            }
            root.left = create(string.substring(2, endBracketIndex - 1), stack);
            if (endBracketIndex + 1 < string.length())
                root.right = create(string.substring(endBracketIndex + 1, string.length() - 1), stack);
        }
        return root;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
