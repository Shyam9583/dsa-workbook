package com.technotap.dsaworkbook.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class DiameterOfATree {
    private static Node createTree(int[] arr) {
        Node root = new Node(arr[0]);
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        insert(q, arr, 1);
        return root;
    }

    private static void insert(Queue<Node> q, int[] arr, int index) {
        if (index == arr.length) return;
        Node node = q.peek();
        if (node != null) {
            if (node.left == null) {
                node.left = new Node(arr[index]);
                q.add(node.left);
                insert(q, arr, index + 1);
            } else if (node.right == null) {
                node.right = new Node(arr[index]);
                q.add(node.right);
                insert(q, arr, index + 1);
            } else {
                q.remove();
                insert(q, arr, index);
            }
        }
    }

    private static int treeDiameter(Node root) {
        if (root == null) return 0;
        int[] ans = {Integer.MIN_VALUE};
        height(root, ans);
        return ans[0];
    }

    private static int height(Node node, int[] ans) {
        if (node == null) return 0;
        int leftHeight = height(node.left, ans);
        int rightHeight = height(node.right, ans);
        ans[0] = Math.max(ans[0], leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 7).toArray();
        Node root = createTree(arr);
        System.out.println(treeDiameter(root));
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
