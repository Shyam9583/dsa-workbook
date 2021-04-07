package com.technotap.dsaworkbook.binarytree;

import java.util.Stack;

public class PreorderTraversal {
    private static void printPreorderRecursive(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null)
            printPreorderRecursive(root.left);
        if (root.right != null)
            printPreorderRecursive(root.right);
    }

    private static void printPreOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                System.out.print(root.data + " ");
                if (root.right != null)
                    stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Node root = createTree();
        printPreorderRecursive(root);
        System.out.println();
        printPreOrderIterative(root);
    }

    private static Node createTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
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
