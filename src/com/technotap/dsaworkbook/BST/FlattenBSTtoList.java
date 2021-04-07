package com.technotap.dsaworkbook.BST;

public class FlattenBSTtoList {

    private static Node createBST(int... arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    private static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value <= root.data) {
            if (root.left == null) root.left = new Node(value);
            else root.left = insert(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = createBST(5, 3, 7, 2, 4, 6, 8);
        print(root);
        root = flatten(root);
        print(root);
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    private static Node flatten(Node root) {
        HeadNext headTailNext = new HeadNext();
        compute(root, headTailNext);
        return headTailNext.head;
    }

    private static void compute(Node root, HeadNext headNext) {
        if (root == null) return;
        compute(root.right, headNext);
        root.right = headNext.next;
        if (headNext.next != null) headNext.next.left = null;
        headNext.next = root;
        headNext.head = root;
        compute(root.left, headNext);
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

    private static class HeadNext {
        Node head = null, next = null;
    }

}
