package java.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfATree {
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

    private static int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 60};
        Node root = createTree(arr);
        int height = height(root);
        System.out.println(height);
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
