package com.technotap.dsaworkbook.BST;

import java.util.Stack;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.Node;
import static com.technotap.dsaworkbook.util.BinaryTreeUtil.createTree;

public class MorrisTreeTraversal {
    public static void main(String[] args) {
        Node root = createTree(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Preorder = " + printPreorder(root));
        System.out.println("Inorder = " + printInorder(root));
        System.out.println("Postorder = " + printPostorder(root));
    }

    private static String printPostorder(Node root) {
        StringBuilder builder = new StringBuilder();
        Stack<Node> first = new Stack<>(), second = new Stack<>();
        first.add(root);
        while (!first.isEmpty()) {
            Node node = first.pop();
            second.push(node);
            if (node.left != null) first.push(node.left);
            if (node.right != null) first.push(node.right);
        }
        while (!second.isEmpty()) {
            builder.append(second.pop().data).append(" ");
        }
        return builder.toString();
    }

    private static String printInorder(Node root) {
        StringBuilder builder = new StringBuilder();
        while (root != null) {
            if (root.left == null) {
                builder.append(root.data).append(" ");
                root = root.right;
            } else {
                Node rightMost = root.left;
                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = root;
                    root = root.left;
                } else {
                    rightMost.right = null;
                    builder.append(root.data).append(" ");
                    root = root.right;
                }
            }
        }
        return builder.toString();
    }

    private static String printPreorder(Node root) {
        StringBuilder builder = new StringBuilder();
        while (root != null) {
            if (root.left == null) {
                builder.append(root.data).append(" ");
                root = root.right;
            } else {
                Node rightMost = root.left;
                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = root;
                    builder.append(root.data).append(" ");
                    root = root.left;
                } else {
                    rightMost.right = null;
                    root = root.right;
                }
            }
        }
        return builder.toString();
    }
}
