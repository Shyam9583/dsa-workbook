package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InOrderTraversal {
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

    private static void printInorderRecursive(Node root) {
        if (root.left != null)
            printInorderRecursive(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            printInorderRecursive(root.right);
    }

    private static void printInOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 4};
        Node root = createTree(arr);
        printInorderRecursive(root);
        System.out.println();
        printInOrderIterative(root);
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
