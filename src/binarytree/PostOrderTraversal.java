package binarytree;

import java.util.Stack;

public class PostOrderTraversal {

    private static Node createTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        return root;
    }

    public static void main(String[] args) {
        Node root = createTree();
        printPostOrderRecursive(root);
        System.out.println();
        printPostOrderIterative(root);
    }

    private static void printPostOrderRecursive(Node root) {
        if (root == null) return;
        if (root.left != null)
            printPostOrderRecursive(root.left);
        if (root.right != null)
            printPostOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    private static void printPostOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<>(), t = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            t.push(root);
            if (root.left != null)
                s.push(root.left);
            if (root.right != null)
                s.push(root.right);
        }
        while (!t.isEmpty()) {
            System.out.print(t.pop().data + " ");
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
