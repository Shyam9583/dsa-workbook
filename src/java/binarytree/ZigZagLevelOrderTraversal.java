package java.binarytree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

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
            Node newNode = arr[index] != -1 ? new Node(arr[index]) : null;
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
        if (root.left != null)
            printInOrder(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 7, 8, 8, 6, -1, 10, 9};
        Node root = createTree(arr);
        System.out.println(zigZag(root));
    }

    private static ArrayList<Integer> zigZag(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> current = new Stack<>(), next = new Stack<>();
        boolean leftToRight = true;
        current.push(root);
        while (!current.isEmpty()) {
            int size = current.size();
            try {
                for (int i = 0; i < size; i++) {
                    Node node = current.pop();
                    if (leftToRight) {
                        if (node.left != null) next.push(node.left);
                        if (node.right != null) next.push(node.right);
                    } else {
                        if (node.right != null) next.push(node.right);
                        if (node.left != null) next.push(node.left);
                    }
                    result.add(node.data);
                }
                Stack<Node> temp = current;
                current = next;
                next = temp;
                leftToRight = !leftToRight;
            } catch (EmptyStackException ignored) {
                break;
            }
        }
        return result;
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
