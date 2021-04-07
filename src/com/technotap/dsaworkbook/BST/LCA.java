package com.technotap.dsaworkbook.BST;

public class LCA {

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    private static Node createBST(int... arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    private static Node insert(Node root, int value) {
        if (root == null) return null;
        if (value <= root.data) {
            if (root.left == null) root.left = new Node(value);
            else root.left = insert(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = createBST(5, 4, 6, 3, 7, 8);
        System.out.println(lca(root, 7, 8));
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data < n1 && root.data < n2) {
            return lca(root.right, n1, n2);
        }
        if (root.data > n1 && root.data > n2) {
            return lca(root.left, n1, n2);
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
