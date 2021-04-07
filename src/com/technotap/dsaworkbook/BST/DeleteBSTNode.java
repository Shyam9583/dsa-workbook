package com.technotap.dsaworkbook.BST;

public class DeleteBSTNode {

    private static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    private static TreeNode createBST(int... arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) return null;
        if (value <= root.val) {
            if (root.left == null) root.left = new TreeNode(value);
            else root.left = insert(root.left, value);
        } else {
            if (root.right == null) root.right = new TreeNode(value);
            else root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = createBST(5, 3, 6, 2, 4, 7);
        print(root);
        System.out.println();
        root = deleteNode(root, 3);
        print(root);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left != null && root.right != null) {
                root.val = leftMost(root.right).val;
                root.right = deleteNode(root.right, root.val);
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                return root.left == null ? root.right : root.left;
            }
        }
        return root;
    }

    private static TreeNode leftMost(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) {
            return leftMost(root.left);
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + val +
                    '}';
        }
    }

}
