package BST;

public class FindAValue {

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
        Node root = createBST(9, 0, 8, 5, 0, 4, 7, 0, 4);
        System.out.println(findValue(root, 3));
        System.out.println(findValue(root, 7));
    }

    private static boolean findValue(Node root, int value) {
        if(root == null) return false;
        if(value == root.data) return true;
        if(value < root.data) return findValue(root.left, value);
        return findValue(root.right, value);
    }

}
