package java.binarytree;

import java.util.*;

public class ViewOfTheTree {

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
            Node newNode = new Node(arr[index]);
            if (node.left == null) {
                node.left = newNode;
                q.add(node.left);
                insert(q, arr, index + 1);
            } else if (node.right == null) {
                node.right = newNode;
                q.add(node.right);
                insert(q, arr, index + 1);
            } else {
                q.remove();
                insert(q, arr, index);
            }
        }
    }

    private static Node root() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = createTree(arr);
        root.left.left.right = new Node(8);
        return root;
    }

    public static void main(String[] args) {
        Node root = root();
        System.out.println("Left View : " + leftView(root));
        System.out.println("Right View : " + rightView(root));
        System.out.print("Top View : ");
        topView(root);
        System.out.print("Bottom View : " + bottomView(root));
    }

    private static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // level wise elements
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node == null)
                    break;
                if (i == 0)
                    result.add(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return result;
    }

    private static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node == null)
                    break;
                if (i == 0)
                    result.add(node.data);
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
        }
        return result;
    }

    private static void topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<LeveledNode> q = new LinkedList<>();
        q.add(new LeveledNode(root, 0));
        while (!q.isEmpty()) {
            LeveledNode leveledNode = q.poll();
            Node node = leveledNode.node;
            int level = leveledNode.level;
            if (node.left != null)
                q.add(new LeveledNode(node.left, level - 1));
            if (node.right != null)
                q.add(new LeveledNode(node.right, level + 1));
            map.putIfAbsent(level, node.data);
        }
        for (int key : map.keySet())
            System.out.print(map.get(key) + " ");
        System.out.println();
    }

    private static ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<LeveledNode> q = new LinkedList<>();
        q.add(new LeveledNode(root, 0));
        while (!q.isEmpty()) {
            LeveledNode leveledNode = q.poll();
            Node node = leveledNode.node;
            int level = leveledNode.level;
            if (node.left != null)
                q.add(new LeveledNode(node.left, level - 1));
            if (node.right != null)
                q.add(new LeveledNode(node.right, level + 1));
            map.put(level, node.data);
        }
        return new ArrayList<>(map.values());
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

    private static class LeveledNode {
        Node node;
        int level;

        LeveledNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }


}
