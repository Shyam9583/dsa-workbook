package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertBinaryTreeToSumTree {

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

    private static void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static void printTree(Node root) {
        printInOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, -2, 6, 8, -4, 7, 5};
        Node root = createTree(arr);
        printTree(root);
        convertToSumTree(root);
        printTree(root);
    }

    private static void convertToSumTree(Node root) {
        if (root == null) return;
        convert(root);
    }

    private static int convert(Node node) {
        if (node == null) return 0;
        int data = node.data;
        node.data = convert(node.left) + convert(node.right);
        return data + node.data;
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
