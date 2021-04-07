package com.technotap.dsaworkbook.BST;

public class PreorderToPostorder {

    private static int index;

    public static void main(String[] args) {
        int[] preorder = {40, 30, 35, 80, 100};
        postorder(preorder, preorder.length);
    }

    private static Node postorder(int[] pre, int size) {
        index = 0;
        Node root = construct(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print(root);
        System.out.println();
        return root;
    }

    private static Node construct(int[] preorder, int min, int max) {
        if (index >= preorder.length) return null;
        if (preorder[index] > min && preorder[index] < max) {
            Node root = new Node(preorder[index++]);
            if (index < preorder.length)
                root.left = construct(preorder, min, root.data);
            if (index < preorder.length)
                root.right = construct(preorder, root.data, max);
            return root;
        }
        return null;
    }

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        print(root.right);
        System.out.print(root.data + " ");
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
