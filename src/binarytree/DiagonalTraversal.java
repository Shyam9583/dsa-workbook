package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {

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
        int[] arr = {8, 3, 10, 1, N, 6, 14, N, N, 4, 7, 13};
        Node root = createTree(arr);
        printDiagonal(root);
    }

    private static void printDiagonal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        exploreNodes(root, map, 0);
        for (int level : map.keySet()) {
            map.get(level).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void exploreNodes(Node node, TreeMap<Integer, ArrayList<Integer>> map, int level) {
        if (node == null) return;
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(node.data);
        exploreNodes(node.left, map, level + 1);
        exploreNodes(node.right, map, level);
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
