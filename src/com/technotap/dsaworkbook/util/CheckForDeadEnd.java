package com.technotap.dsaworkbook.util;

import java.util.HashMap;
import java.util.Map;

import static com.technotap.dsaworkbook.util.BinaryTreeUtil.Node;
import static com.technotap.dsaworkbook.BST.ContainsDeadEnd.createBST;

public class CheckForDeadEnd {
    public static void main(String[] args) {
        Node root = createBST(47, 92, 21, 117, 34, 63, 51, 77, 2, 106, 46, 45, 88, 57);
        System.out.println(hasDeadEnd(root));
    }

    private static Node createBST(int...arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    private static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (root.data < value) {
            root.right = insert(root.right, value);
        } else {
            root.left = insert(root.left, value);
        }
        return root;
    }

    private static boolean hasDeadEnd(Node root) {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(0, false);
        visit(root, map);
        for (int x : map.keySet()) {
            if (map.get(x)) {
                if (map.containsKey(x - 1) && map.containsKey(x + 1)) return true;
            }
        }
        return false;
    }

    private static void visit(Node root, Map<Integer, Boolean> map) {
        if (root == null) return;
        map.put(root.data, (root.left == null) || (root.right == null));
        visit(root.left, map);
        visit(root.right, map);
    }
}