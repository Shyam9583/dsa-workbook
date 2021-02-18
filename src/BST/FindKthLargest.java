package BST;

public class FindKthLargest {

    private static class Result {
        int k, result = -1;
        Result(int k) {
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

    private static void print(Node root) {
        if(root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    private static Node createBST(int...arr) {
        if(arr.length == 0) return null;
        Node root = new Node(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    private static Node insert(Node root, int value) {
        if(root == null) return null;
        if(value <= root.data) {
            if(root.left == null) root.left = new Node(value);
            else root.left = insert(root.left, value);
        } else {
            if(root.right == null) root.right = new Node(value);
            else root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = createBST(9, 10);
        System.out.println(kthLargest(root, 3));
    }

    private static int kthLargest(Node root, int k) {
        if(root == null) return -1;
        Result result = new Result(k);
        reverseInorder(root, result);
        return result.result;
    }

    private static void reverseInorder(Node root, Result result) {
        if(root == null) return;
        reverseInorder(root.right, result);
        if(--result.k == 0) result.result = root.data;
        reverseInorder(root.left, result);
    }
}
