package java.BST;

import java.util.Arrays;

public class ReplaceWithLeastGreaterElement {

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
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
        int[] list = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        System.out.println(Arrays.toString(list));
        replace(list);
        System.out.println(Arrays.toString(list));
    }

    private static void replace(int[] list) {
        Node root = null;
        for (int i = list.length - 1; i >= 0; i--) {
            root = insert(root, list[i]);
            Successor succ = new Successor();
            inorderSuccessor(root, succ, list[i]);
            list[i] = succ.node != null ? succ.node.data : -1;
        }
    }

    private static void inorderSuccessor(Node root, Successor succ, int key) {
        if (root == null) return;
        if (root.data == key) {
            if (root.right != null)
                succ.node = leftMost(root.right);
        } else if (root.data > key) {
            succ.node = root;
            inorderSuccessor(root.left, succ, key);
        } else inorderSuccessor(root.right, succ, key);
    }

    private static Node leftMost(Node root) {
        if (root.left != null) return leftMost(root.left);
        return root;
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

    private static class Successor {
        Node node = null;
    }

}
