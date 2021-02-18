package BST;

public class FindKthSmallest {

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
        Node root = createBST(2, 1, 3);
        System.out.println(kthSmallest(root, 3));
    }

    private static int kthSmallest(Node root, int k) {
        State state = new State(k);
        traverse(root, state);
        return state.result;
    }

    private static void traverse(Node root, State state) {
        if (root == null) return;
        traverse(root.left, state);
        if (--state.k == 0) state.result = root.data;
        traverse(root.right, state);
    }

    private static class State {
        int k, result = -1;

        State(int k) {
            this.k = k;
        }
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
