package com.technotap.dsaworkbook.binarytree;

import java.util.*;

public class ReverseLevelOrderTraversal {

    public static final int NULL = -1;

    public static void main(String[] args) {
        Node root = construct();
        List<Integer> result = reverseLevelOrder(root);
        System.out.println(result);
    }

    public static Node createTree(int...arr) {
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.add(root);
        insert(arr, 1, queue);
        return root;
    }

    private static void insert(int[] arr, int pos, Queue<Node> queue) {
        if (pos == arr.length) return;
        Node newNode = arr[pos] == NULL ? null : new Node(arr[pos]);
        Node root = queue.peek();
        if (root == null) return;
        if ((pos & 1) == 1) {
            root.left = newNode;
        } else {
            root.right = newNode;
            queue.poll();
        }
        if (newNode != null) queue.add(newNode);
        insert(arr, pos + 1, queue);
    }

    private static List<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        q.add(root);
        while (q.size() > 0) {
            Node node = q.poll();
            if (node.right != null)
                q.add(node.right);
            if (node.right != null)
                q.add(node.left);
            stack.push(node.data);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static Node construct() {
        return createTree(10, 20, 30, 40, 50, 60, 70);
    }

    public static class Node {
        public int data;
        public Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
