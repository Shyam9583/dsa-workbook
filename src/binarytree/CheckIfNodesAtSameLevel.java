package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckIfNodesAtSameLevel {

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
        Node root = createTree(new int[]{1691, 6733, N, 5989, 6640, N, 2750, 3565, N, 1371, 5003, N, 1677, 8921, N, 8413, 7729, N, 7679, 2475, N, 2822, 6415, N, 3872});
        System.out.println(sameLevel(root));
    }

    private static boolean sameLevel(Node root) {
        int[] lastLevel = {-1};
        boolean[] result = {true};
        compute(root, 0, result, lastLevel);
        return result[0];
    }

    private static void compute(Node node, int current, boolean[] result, int[] lastLevel) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (lastLevel[0] != -1) {
                result[0] = result[0] && (lastLevel[0] == current);
            }
            lastLevel[0] = current;
        }
        compute(node.left, current + 1, result, lastLevel);
        compute(node.right, current + 1, result, lastLevel);
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
