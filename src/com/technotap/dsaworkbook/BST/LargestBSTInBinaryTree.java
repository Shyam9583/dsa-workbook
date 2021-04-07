package com.technotap.dsaworkbook.BST;

import java.util.ArrayDeque;
import java.util.Queue;

public class LargestBSTInBinaryTree {

    private static final int N = Integer.MIN_VALUE;

    private static Node createTree(int... arr) {
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
            Node newNode = arr[index] != N ? new Node(arr[index]) : null;
            if ((index & 1) == 1) {
                node.left = newNode;
                if (newNode != null)
                    q.add(node.left);
            } else {
                node.right = newNode;
                if (newNode != null)
                    q.add(node.right);
                q.poll();
            }
            insert(q, arr, index + 1);
        }
    }

    public static void main(String[] args) {
        Node root = createTree(6, 6, 3, N, 2, 9, 3, N, 8, 8, 2);
        System.out.println(largestBST(root));
    }

    private static int largestBST(Node root) {
        Result result = compute(root);
        return result.size;
    }

    private static Result compute(Node root) {
        if (root == null) return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = compute(root.left);
        Result right = compute(root.right);
        boolean isBST = left.isBST && right.isBST && left.max < root.data && right.min > root.data;
        int size = isBST ? left.size + right.size + 1 : Math.max(left.size, right.size);
        int min = Math.min(left.min, Math.min(root.data, right.min));
        int max = Math.max(left.max, Math.max(root.data, right.max));
        return new Result(isBST, size, min, max);
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

    private static class Result {
        boolean isBST;
        int size, min, max;

        Result(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
