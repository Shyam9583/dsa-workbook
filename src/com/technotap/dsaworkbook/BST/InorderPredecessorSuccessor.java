package com.technotap.dsaworkbook.BST;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.Node;
import static com.technotap.dsaworkbook.util.BinaryTreeUtil.createTree;

public class InorderPredecessorSuccessor {
    public static void main(String[] args) {
        Node root = createTree(50, 30, 70, 20, 40, 60, 80);
        int key = 10;
        int[] result = predecessor_successor(root, key);
        System.out.println("Predecessor = " + result[0] + ", Successor = " + result[1]);
    }

    private static Node leftMost(Node root) {
        if (root.left != null) return leftMost(root.left);
        return root;
    }

    private static Node rightMost(Node root) {
        if (root.right != null) return rightMost(root.right);
        return root;
    }

    private static int[] predecessor_successor(Node root, int key) {
        Node[] predecessor = {null}, successor = {null};
        find(root, key, successor, predecessor);
        return new int[]{
                predecessor[0] == null ? Integer.MIN_VALUE : predecessor[0].data,
                successor[0] == null ? Integer.MAX_VALUE : successor[0].data
        };
    }

    private static void find(Node root, int key, Node[] successor, Node[] predecessor) {
        if (root == null) return;
        if (root.data == key) {
            if (root.right != null) successor[0] = leftMost(root.right);
            if (root.left != null) predecessor[0] = rightMost(root.left);
        } else if (root.data > key) {
            successor[0] = root;
            find(root.left, key, successor, predecessor);
        } else {
            predecessor[0] = root;
            find(root.right, key, successor, predecessor);
        }
    }
}
