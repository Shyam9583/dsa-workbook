package com.technotap.dsaworkbook.BST;

public class CountNodesInRange {

    private static void print(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        print(root.left);
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
        Node root = createBST(5, 4, 6, 3, 7);
        System.out.println(getCount(root, 2, 8));
    }

    private static int getCount(Node root, int l, int h) {
        if (root == null) return 0;
        if (root.data >= l && root.data <= h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        } else if (root.data < l) {
            return getCount(root.right, l, h);
        }
        return getCount(root.left, l, h);
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
