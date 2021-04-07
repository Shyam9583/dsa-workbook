package java.binarytree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class CheckForDuplicateSubtrees {

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
        Node root = createTree(new int[]{1, 2, 3});
        System.out.println(containsDuplicateSubtrees(root));
    }

    private static boolean containsDuplicateSubtrees(Node root) {
        HashMap<Long, Integer> map = new HashMap<>();
        compute(root, map);
        for (long key : map.keySet()) {
            if (map.get(key) > 1)
                return true;
        }
        return false;
    }

    private static long compute(Node node, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        long left = compute(node.left, map);
        long right = compute(node.right, map);
        long hash = (left * right * node.data) + (left + right + node.data);
        if (node.left != null || node.right != null) {
            if (map.containsKey(hash))
                map.replace(hash, map.get(hash) + 1);
            else
                map.put(hash, 1);
        }
        return hash;
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
