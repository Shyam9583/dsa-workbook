package com.technotap.dsaworkbook.BST;

import java.util.ArrayList;

public class ConvertBSTtoBalancedBST {

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
        Node root = createBST(1, 2, 3, 4);
        print(root);
        System.out.println();
        root = constructBalancedBST(root);
        print(root);
    }

    private static Node constructBalancedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return constructBalancedBSTUtil(list, 0, list.size() - 1);
    }

    private static Node constructBalancedBSTUtil(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        Node root = new Node(list.get(mid));
        root.left = constructBalancedBSTUtil(list, start, mid - 1);
        root.right = constructBalancedBSTUtil(list, mid + 1, end);
        return root;
    }

    private static void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
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
