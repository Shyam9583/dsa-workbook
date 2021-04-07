package java.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConvertBinaryTreeToBST {

    private static final int N = Integer.MIN_VALUE;
    private static int index = 0;

    private static Node createTree(int... arr) {
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
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

    private static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    public static void main(String[] args) {
        Node root = createTree(1, 2, 3, 4);
        Node bstRoot = construct(root);
        print(bstRoot);
    }

    private static Node construct(Node root) {
        if (root == null) return null;
        ArrayList<Integer> inorder = new ArrayList<>();
        traversal(root, inorder);
        inorder.sort(Integer::compareTo);
        inorderToBST(inorder, root);
        return root;
    }

    private static void inorderToBST(ArrayList<Integer> inorder, Node root) {
        if (root == null) return;
        inorderToBST(inorder, root.left);
        root.data = inorder.get(index++);
        inorderToBST(inorder, root.right);
    }

    private static void traversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        traversal(root.left, inorder);
        inorder.add(root.data);
        traversal(root.right, inorder);
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
