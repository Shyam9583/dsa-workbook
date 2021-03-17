package heap;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBSTToMinHeap {
    public static void main(String[] args) {
        Node root = createBST(4, 2, 6, 1, 3, 5, 7);
        convert(root);
        print(root);
    }

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    private static void convert(Node root) {
        Queue<Integer> inorder = new LinkedList<>();
        inorderTraverse(root, inorder);
        preorderTraverse(root, inorder);
    }

    private static void preorderTraverse(Node root, Queue<Integer> inorder) {
        if (root == null) return;
        root.data = inorder.remove();
        preorderTraverse(root.left, inorder);
        preorderTraverse(root.right, inorder);
    }

    private static void inorderTraverse(Node root, Queue<Integer> inorder) {
        if (root == null) return;
        inorderTraverse(root.left, inorder);
        inorder.add(root.data);
        inorderTraverse(root.right, inorder);
    }

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
        if (value <= root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
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
