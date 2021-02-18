package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LargestSubtreeSum {

    private static final int N = Integer.MIN_VALUE;

    private static Node createTree(int[] arr) {
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
        Node root = createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(maxSum(root));
    }

    private static int maxSum(Node root) {
        int[] result = {Integer.MIN_VALUE};
        computeSum(root, result);
        return result[0];
    }

    private static int computeSum(Node node, int[] result) {
        if (node == null) return 0;
        int sum = computeSum(node.left, result) + computeSum(node.right, result) + node.data;
        if (sum > result[0])
            result[0] = sum;
        return sum;
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
