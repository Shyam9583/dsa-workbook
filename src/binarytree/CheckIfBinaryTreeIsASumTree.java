package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckIfBinaryTreeIsASumTree {

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
        Node root = createTree(new int[]{62, 16, 15, N, 8, 4, 7, N, 8, 4});
        System.out.println(isASumTree(root));
    }

    private static boolean isASumTree(Node root) {
        if (root == null) return true;
        return isNodeASumTree(root).isSumTree;
    }

    private static NodeState isNodeASumTree(Node node) {
        if (node == null) return new NodeState(0, true);
        if (node.left == null && node.right == null) return new NodeState(node.data, true);
        NodeState left = isNodeASumTree(node.left);
        NodeState right = isNodeASumTree(node.right);
        boolean isSumTree = ((left.data + right.data) == node.data);
        return new NodeState(node.data + left.data + right.data, isSumTree);
    }

    private static class NodeState {
        int data;
        boolean isSumTree;

        NodeState(int data, boolean isSumTree) {
            this.data = data;
            this.isSumTree = isSumTree;
        }
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
