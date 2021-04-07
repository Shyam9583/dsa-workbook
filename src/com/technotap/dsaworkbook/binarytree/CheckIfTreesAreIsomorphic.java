package com.technotap.dsaworkbook.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTreesAreIsomorphic {

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
        Node firstRoot = createTree(1, 2, 3, 4);
        Node secondRoot = createTree(1, 3, 2, 4);
        System.out.println(isIsomorphic(firstRoot, secondRoot));
    }

    private static boolean isIsomorphic(Node first, Node second) {
        if (first == null || second == null) return first == second;
        boolean mirror = isIsomorphic(first.left, second.right) && isIsomorphic(first.right, second.left);
        boolean same = isIsomorphic(first.left, second.left) && isIsomorphic(first.right, second.right);
        return first.data == second.data && (mirror || same);
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
