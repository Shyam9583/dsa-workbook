package com.technotap.dsaworkbook.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertBinaryTreeToDoublyLinkedList {

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

    private static void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 25, 30, 36};
        Node root = createTree(arr);
        printInOrder(root);
        System.out.println();
        Node head = createList(root);
        printList(head);
    }

    private static Node createList(Node root) {
        if (root == null) return null;
        Node[] HeadPrev = {null, null};
        constructList(root, HeadPrev);
        return HeadPrev[0];
    }

    private static void constructList(Node node, Node[] HeadPrev) {
        if (node == null) return;
        constructList(node.left, HeadPrev);
        if (HeadPrev[1] == null)
            HeadPrev[0] = node;
        else {
            node.left = HeadPrev[1];
            HeadPrev[1].right = node;
        }
        HeadPrev[1] = node;
        constructList(node.right, HeadPrev);
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
