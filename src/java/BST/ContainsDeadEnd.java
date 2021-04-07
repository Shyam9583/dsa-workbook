package java.BST;

import java.util.TreeMap;

public class ContainsDeadEnd {

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

    public static void main(String[] args) {
        Node root = createBST(47, 92, 21, 117, 34, 63, 51, 77, 2, 106, 46, 45, 88, 57);
        System.out.println(result(root));
    }

    private static boolean containsDeadEnd(Node root) {
        TreeMap<Integer, Boolean> leafMap = new TreeMap<>();
        visit(root, leafMap);
        for (int n : leafMap.keySet()) {
            if (leafMap.get(n)) {
                if (n == 1 && leafMap.containsKey(n + 1)) return true;
                if (leafMap.containsKey(n - 1) && leafMap.containsKey(n + 1)) return true;
            }
        }
        return false;
    }

    private static void visit(Node root, TreeMap<Integer, Boolean> leafMap) {
        if (root == null) return;
        visit(root.left, leafMap);
        leafMap.put(root.data, (root.left == null || root.right == null));
        visit(root.right, leafMap);
    }

    private static boolean result(Node root) {
        return containsDeadEndWithoutMap(root, root);
    }

    private static boolean containsDeadEndWithoutMap(Node node, Node root) {
        if (node == null) return false;
        boolean left = containsDeadEndWithoutMap(node.left, root);
        boolean right = containsDeadEndWithoutMap(node.right, root);
        if (node.left == null && node.right == null) {
            boolean pre = node.data == 1 || contains(root, node.data - 1);
            boolean next = contains(root, node.data + 1);
            return left || right || (pre && next);
        }
        return left || right;
    }

    private static boolean contains(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (root.data > key) return contains(root.left, key);
        return contains(root.right, key);
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
