package java.BST;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForBST {

    private static final int N = Integer.MIN_VALUE;

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

    public static void main(String[] args) {
        Node root = createTree(1, 1, 1, 1, 1, N, 1, 1, 1, 1, 1);
        System.out.println(isBinaryTree(root));
    }

    private static boolean isBinaryTree(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinaryTreeUtil(Node root, HashMap<Node, Boolean> dp) {
        if (root == null) return true;
        if (dp.containsKey(root)) return dp.get(root);
        boolean leftIsBST = true, rightIsBST = true;
        if (root.left != null) {
            leftIsBST = root.left.data < root.data;
        }
        if (root.right != null) {
            rightIsBST = root.right.data > root.data;
        }
        dp.putIfAbsent(root, leftIsBST && rightIsBST);
        return dp.get(root);
    }

    private static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
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
