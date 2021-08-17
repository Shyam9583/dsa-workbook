package com.technotap.dsaworkbook.util;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

    public static int NULL = Integer.MIN_VALUE >> 1;

    public static Node createTree(int... arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < arr.length; i++) {
            Node newNode = arr[i] == NULL ? null : new Node(arr[i]);
            Node curr = queue.peek();
            if (curr == null) break;
            if ((i & 1) == 1) {
                curr.left = newNode;
            } else {
                curr.right = newNode;
                queue.poll();
            }
            if (newNode != null) queue.add(newNode);
        }
        return root;
    }

    public static class Node {
        public Node left, right;
        public int data;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", data=" + data +
                    '}';
        }
    }
}
