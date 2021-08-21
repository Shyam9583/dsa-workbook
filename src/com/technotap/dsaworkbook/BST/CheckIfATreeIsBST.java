package com.technotap.dsaworkbook.BST;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.*;

public class CheckIfATreeIsBST {
    public static void main(String[] args) {
        Node root = createTree(1, 1, 1, 1, 1, NULL, 1, 1, 1, 1, 1);
        System.out.println(isBST(root));
    }

    private static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data > max || root.data < min) return false;
        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
    }
}
