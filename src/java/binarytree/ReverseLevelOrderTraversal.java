package java.binarytree;

import java.util.*;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        Node root = construct();
        List<Integer> result = reverseLevelOrder(root);
        System.out.println(result);
    }

    private static List<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        q.add(root);
        while (q.size() > 0) {
            Node node = q.poll();
            if (node.right != null)
                q.add(node.right);
            if (node.right != null)
                q.add(node.left);
            stack.push(node.data);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static Node construct() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        return root;
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
