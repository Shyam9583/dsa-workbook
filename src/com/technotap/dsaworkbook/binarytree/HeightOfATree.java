package com.technotap.dsaworkbook.binarytree;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.*;

public class HeightOfATree {
    public static void main(String[] args) {
        Node root = createTree(10, 20, 30, 40, 50, NULL, NULL, 60);
        System.out.println(height(root));
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
