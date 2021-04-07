package java.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MirrorTree {
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

    private static void printInorder(Node root) {
        if (root.left != null)
            printInorder(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 4};
        Node original = createTree(arr);
        printInorder(original);
        System.out.println();
        Node mirror = mirrorOf(original);
        printInorder(mirror);
    }

    private static Node mirrorOf(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.data);
        newNode.left = mirrorOf(node.right);
        newNode.right = mirrorOf(node.left);
        return newNode;
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
