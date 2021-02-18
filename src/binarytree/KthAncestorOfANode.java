package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class KthAncestorOfANode {

    private static final int N = Integer.MIN_VALUE;
    private static int K;

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
        Node root = createTree(1, 2, 3, 4, 5);
        kthAncestor(root, 4, 2);
        kthAncestor(root, 5, 1);
    }

    private static void kthAncestor(Node root, int target, int k) {
        K = k;
        kthAncestorUtil(root, target);
    }

    private static Node kthAncestorUtil(Node node, int target) {
        if (node == null) return null;
        if (node.data == target || kthAncestorUtil(node.left, target) != null || kthAncestorUtil(node.right, target) != null) {
            if (K > 0) K--;
            if (K == 0) {
                System.out.println(node.data);
                return null;
            }
            return node;
        }
        return null;
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
