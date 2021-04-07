package java.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BoundaryTraversal {

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

    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, N, 25, N, N, 10, 14};
        Node root = createTree(arr);
        System.out.println(boundaryTraversal(root));
    }

    private static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.data);
        leftBoundary(root.left, result);
        leafNodes(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private static void leftBoundary(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (node.left != null) {
            result.add(node.data);
            leftBoundary(node.left, result);
        } else if (node.right != null) {
            result.add(node.data);
            leftBoundary(node.right, result);
        }
    }

    private static void rightBoundary(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (node.right != null) {
            rightBoundary(node.right, result);
            result.add(node.data);
        } else if (node.left != null) {
            rightBoundary(node.left, result);
            result.add(node.data);
        }
    }

    private static void leafNodes(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        leafNodes(node.left, result);
        if (node.left == null && node.right == null) {
            result.add(node.data);
        }
        leafNodes(node.right, result);
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
