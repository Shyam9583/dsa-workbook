package com.technotap.dsaworkbook.binarytree;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.Node;
import static com.technotap.dsaworkbook.util.BinaryTreeUtil.createTree;

public class SumTree {
    public static void main(String[] args) {
        Node root = createTree(10, -2, 6, 8, -4, 7, 5);
        printTree(root);
        System.out.println();
        toSumTree(root);
        printTree(root);
    }

    private static void toSumTree(Node root) {
        if (root != null) {
            toSumTreeUtil(root);
        }
    }

    private static int toSumTreeUtil(Node root) {
        if (root == null) return 0;
        int oldValue = root.data;
        root.data = toSumTreeUtil(root.left) + toSumTreeUtil(root.right);
        return oldValue + root.data;
    }

    private static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
}
