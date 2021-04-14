package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LargestIndependentSet {

    private static final int N = -1;

    public static void main(String[] args) {
        Node root = createTree(10, 20, 30, 40, 50, N, 60, N, N, 70, 80);
        System.out.println(LISS(root));
    }

    private static Node createTree(int... arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        insert(q, arr, 1);
        return root;
    }

    private static void insert(Queue<Node> q, int[] arr, int idx) {
        if (idx == arr.length) return;
        Node root = q.peek();
        if (root != null) {
            Node newNode = (arr[idx] == N) ? null : new Node(arr[idx]);
            if ((idx & 1) == 1) {
                root.left = newNode;
            } else {
                root.right = newNode;
                q.remove();
            }
            if (newNode != null) q.add(newNode);
            insert(q, arr, idx + 1);
        }
    }

    private static int LISS(Node root) {
        Map<Node, Integer> map = new HashMap<>();
        return traverse(root, map);
    }

    private static int traverse(Node root, Map<Node, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int children = traverse(root.left, map) + traverse(root.right, map);
        int grandChildren = 0;
        if (root.left != null) {
            grandChildren += traverse(root.left.left, map);
            grandChildren += traverse(root.left.right, map);
        }
        if (root.right != null) {
            grandChildren += traverse(root.right.left, map);
            grandChildren += traverse(root.right.right, map);
        }
        map.put(root, Math.max(1 + grandChildren, children));
        return map.get(root);
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            left = right = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
