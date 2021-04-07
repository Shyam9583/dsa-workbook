package java.heap;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsHeap {
    private static final int N = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = createTree(10, 20, 30, 40, 60);
        System.out.println(isHeap(root));
    }

    private static boolean isHeap(Node root) {
        if (root == null) return true;
        boolean result = true;
        if (root.left != null) {
            result = root.data >= root.left.data && isHeap(root.left);
        }
        if (root.right != null) {
            result = result && (root.data >= root.right.data) && isHeap(root.right);
        }
        return result;
    }

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

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
