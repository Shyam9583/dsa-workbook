package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintPathWithSumK {

    private static final int N = Integer.MIN_VALUE;

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
        Node root = createTree(new int[] { 1, 3, -1, 2, 1, 4, 5, N, N, 1, N, 1, 2, N, 6 });
        print(root, 5);
    }

    private static void print(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, k, path);
    }

    private static void traverse(Node node, int k, ArrayList<Integer> path) {
        if(node == null) return;
        path.add(node.data);
        traverse(node.left, k, path);
        traverse(node.right, k, path);
        int sum = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if(sum == k) {
                for(int j = i; j < path.size(); j++) {
                    System.out.print(path.get(j) + " ");
                }
                System.out.println();
            }
        }
        path.remove(path.size() - 1);
    }

}
