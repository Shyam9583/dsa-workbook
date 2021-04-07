package com.technotap.dsaworkbook.binarytree;

import java.util.Arrays;

public class CreateBinaryTreeFromPreorderAndInorder {

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        print(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(inorder, preorder, preorder.length);
        print(root);
    }

    private static Node buildTree(int[] inorder, int[] preorder, int n) {
        if (preorder.length == 0) return null;
        Node root = new Node(preorder[0]);
        int rootLocation = indexOf(inorder, root.data);
        if (rootLocation == 0) {
            root.right = buildTree(Arrays.copyOfRange(inorder, 1, n), Arrays.copyOfRange(preorder, 1, n), n - 1);
        } else if (rootLocation == n - 1) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, n - 1), Arrays.copyOfRange(preorder, 1, n), n - 1);
        } else {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootLocation), Arrays.copyOfRange(preorder, 1, rootLocation + 1), rootLocation);
            root.right = buildTree(Arrays.copyOfRange(inorder, rootLocation + 1, n), Arrays.copyOfRange(preorder, rootLocation + 1, n), n - rootLocation - 1);
        }
        return root;
    }

    private static int indexOf(int[] inorder, int key) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == key)
                return i;
        }
        return -1;
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
