package com.technotap.dsaworkbook.binarytree;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.Node;
import static com.technotap.dsaworkbook.util.BinaryTreeUtil.createTree;

public class ConvertBinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {
        Node root = createTree(10, 12, 15, 25, 30, 36);
        printTree(root);
        System.out.println();
        Node head = convertToLL(root);
        printList(head);
    }

    private static Node convertToLL(Node root) {
        if (root == null) return null;
        Node[] head = {null}, prev = {null};
        convertUtil(root, head, prev);
        return head[0];
    }

    private static void convertUtil(Node curr, Node[] head, Node[] prev) {
        if (curr == null) return;
        convertUtil(curr.left, head, prev);
        if (prev[0] == null) {
            head[0] = curr;
        } else {
            curr.left = prev[0];
            prev[0].right = curr;
        }
        prev[0] = curr;
        convertUtil(curr.right, head, prev);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    private static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
}
