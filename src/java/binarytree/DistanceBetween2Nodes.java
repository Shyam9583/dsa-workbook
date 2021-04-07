package java.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceBetween2Nodes {

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
        Node root = createTree(new int[]{8, 6, 69, 1, 7, 29, 80, N, 4, N, N, 15, 31, 75, 96, 3, 5, 10, 21, 30, 57, 71, 78, 92, 97, 2, 96, 97});
//        Node root = createTree(new int[] { 1, 2, 3 });
        System.out.println(minDistance(root, 96, 97));
    }

    private static int minDistance(Node root, int a, int b) {
        if (root == null) return -1;
        Node lca = lca(root, a, b);
        if (lca == null) return -1;
        Result rootToA = new Result(), rootToB = new Result(), rootToLca = new Result();
        distance(root, a, 0, rootToA);
        distance(root, b, 0, rootToB);
        distance(root, lca.data, 0, rootToLca);
        return rootToA.distance + rootToB.distance - 2 * rootToLca.distance;
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        else if (left != null) {
            return left;
        } else return right;
    }

    private static void distance(Node node, int target, int len, Result result) {
        if (node == null) return;
        if (node.data == target) {
            result.distance = len;
            return;
        }
        distance(node.left, target, len + 1, result);
        distance(node.right, target, len + 1, result);
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

    private static class Result {
        int distance = 0;
    }
}
