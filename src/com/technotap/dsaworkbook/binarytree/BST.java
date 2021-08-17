package com.technotap.dsaworkbook.binarytree;

public class BST {

    private static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private static Node create(int[] arr) {
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++)
            root = insert(root, arr[i]);
        return root;
    }

    private static void printInOrder(Node root) {
        if (root.left != null)
            printInOrder(root.left);
        System.out.println(root.data);
        if (root.right != null)
            printInOrder(root.right);
    }

    private static boolean contains(Node root, int value) {
        if (root == null) return false;
        if (value == root.data) return true;
        else if (value < root.data)
            return contains(root.left, value);
        else
            return contains(root.right, value);
    }

    private static Node delete(Node root, int value) {
        if (root == null) return null;
        if (value == root.data) {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null)
                root = root.left;
            else {
                int min = min(root.right);
                root.data = min;
                root.right = delete(root.right, min);
            }
        } else if (value < root.data) {
            root.left = delete(root.left, value);
        } else {
            root.right = delete(root.right, value);
        }
        return root;
    }

    private static int min(Node root) {
        return root.left == null ? root.data : min(root.left);
    }

    public static void main(String[] args) {
        int[] arr = {10, 6, 14, 4, 7, 12, 15, 3, 5, 8, 11, 13, 2, 9, 1};
        Node root = create(arr);
        root = delete(root, 6);
        printInOrder(root);
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}