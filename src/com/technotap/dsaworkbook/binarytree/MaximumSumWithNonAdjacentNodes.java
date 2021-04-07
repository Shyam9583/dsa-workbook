package com.technotap.dsaworkbook.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumWithNonAdjacentNodes {

    private static final int N = Integer.MIN_VALUE;

    private static Node createTree(int... arr) {
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
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
        Node root = createTree(1, 2, 3, 1, N, 4, 5);
        System.out.println(max(root));
    }

    private static int max(Node root) {
        HashMap<Node, Integer> dp = new HashMap<>();
        return sum(root, dp);
    }

    private static int sum(Node node, HashMap<Node, Integer> dp) {
        if (node == null) return 0;
        if (dp.containsKey(node)) return dp.get(node);
        int inc = node.data;
        if (node.left != null) {
            inc += sum(node.left.left, dp);
            inc += sum(node.left.right, dp);
        }
        if (node.right != null) {
            inc += sum(node.right.left, dp);
            inc += sum(node.right.right, dp);
        }
        int exc = sum(node.left, dp) + sum(node.right, dp);
        dp.put(node, Math.max(inc, exc));
        return dp.get(node);
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
