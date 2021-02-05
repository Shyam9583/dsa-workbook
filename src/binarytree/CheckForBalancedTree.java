package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckForBalancedTree {

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
        int[] arr = {26, 54, 8, 90, 97, 69, 60, 77, 35, 7, 31, 89, 17, 47,
                69, 77, 54, 62, 55, 67, 47, 67, 50, 81, 97, 18, 21, 8, 22,
                16, 38, 100, 90, 95, 27, 13, N, 21, 33, 81, 29, 79, 32, 9,
                93, 27, 44, 10, 61, 82, 64, 51, 49, 93, 71, 16, 78, 59, 43,
                47, 6, 92, 45, 14, 84, 36, 91, 16, 35, 5, 58, 87, 50, N, 76,
                75, 84};
        Node root = createTree(arr);
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(Node root) {
        if (root == null) return true;
        return nodeState(root).isBalanced;
    }

    private static NodeState nodeState(Node node) {
        if (node == null) return new NodeState(0, true);
        NodeState left = nodeState(node.left);
        NodeState right = nodeState(node.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = (Math.abs(left.height - right.height) <= 1) && (left.isBalanced && right.isBalanced);
        return new NodeState(height, isBalanced);
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

    private static class NodeState {
        int height;
        boolean isBalanced;

        NodeState(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

}
