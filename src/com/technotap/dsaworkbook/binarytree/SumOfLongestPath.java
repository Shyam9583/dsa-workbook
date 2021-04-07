package com.technotap.dsaworkbook.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumOfLongestPath {

    private static final int N = Integer.MIN_VALUE;

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
        Node root = createTree(new int[]{1, 2, 3});
        System.out.println(longestPathSum(root));
    }

    private static int longestPathSum(Node root) {
        if (root == null) return 0;
        Result result = new Result();
        compute(root, 0, 0, result);
        return result.sum;
    }

    private static void compute(Node node, int level, int sum, Result result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            int currentSum = sum + node.data;
            if (level > result.len) {
                result.len = level;
                result.sum = currentSum;
            } else if (level == result.len) {
                result.sum = Math.max(result.sum, currentSum);
            }
        }
        compute(node.left, level + 1, sum + node.data, result);
        compute(node.right, level + 1, sum + node.data, result);
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
        int len = Integer.MIN_VALUE;
        int sum = 0;
    }

}
