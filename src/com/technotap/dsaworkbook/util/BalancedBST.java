package com.technotap.dsaworkbook.util;

import java.util.stream.IntStream;

public class BalancedBST {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        IntStream.of(10, 20, 30, 40, 50, 25).forEach(tree::insert);
        System.out.println(tree);
        System.out.println(tree.height());
    }

    private static class AVLTree {
        Node root = null;

        int height() {
            return height(root);
        }

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private Node rotateLeft(Node node) {
            Node left = node.left;

            if (left == null) return node;
            Node temp = left.right;

            left.right = node;
            node.left = temp;

            left.height = Math.max(height(left.left), height(left.right)) + 1;
            node.height = Math.max(height(node.left), height(node.right)) + 1;

            return left;
        }

        private Node rotateRight(Node node) {
            Node right = node.right;

            if (right == null) return node;
            Node temp = right.left;

            right.left = node;
            node.right = temp;

            right.height = Math.max(height(right.left), height(right.right)) + 1;
            node.height = Math.max(height(node.left), height(node.right)) + 1;

            return right;
        }

        private int balance(Node node) {
            if (node == null) return 0;
            return height(node.left) - height(node.right);
        }

        private Node insertNode(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.data) node.left = insertNode(node.left, key);
            else if (key > node.data) node.right = insertNode(node.right, key);
            else return node;

            node.height = Math.max(height(node.left), height(node.right)) + 1;

            int balance = balance(node);

            if (balance > 1 && key < node.left.data) return rotateRight(node);

            if (balance < -1 && key > node.right.data) return rotateLeft(node);

            if (balance > 1 && key > node.left.data) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

            if (balance < -1 && key < node.right.data) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            return node;
        }

        void insert(int key) {
            root = (root == null) ? new Node(key) : insertNode(root, key);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            print(root, builder);
            return builder.toString();
        }

        private void print(Node root, StringBuilder builder) {
            if (root == null) return;
            builder.append(root.data).append(" ");
            print(root.left, builder);
            print(root.right, builder);
        }
    }

    private static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", height=" + height +
                    '}';
        }
    }
}
