package BST;

public class ConstructBSTFromPreOrder {

    private static int index = 0;

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
        if (root == null) return null;
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
        int[] preorder = {10, 5, 1, 7, 40, 50};
        Node root = BST(preorder);
        print(root);
    }

    private static Node BST(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node construct(int[] preorder, int min, int max) {
        if (index >= preorder.length) return null;
        if (preorder[index] > min && preorder[index] < max) {
            Node root = new Node(preorder[index++]);
            if (index < preorder.length) {
                root.left = construct(preorder, min, root.data);
            }
            if (index < preorder.length) {
                root.right = construct(preorder, root.data, max);
            }
            return root;
        }
        return null;
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
