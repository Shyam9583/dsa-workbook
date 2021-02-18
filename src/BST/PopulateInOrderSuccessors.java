package BST;

public class PopulateInOrderSuccessors {

    private static class Node {
        int data;
        Node left, right, next;
        Node(int data) {
            this.data = data;
            this.left = this.right = this.next = null;
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
        System.out.println(root.data + ", " + (root.next != null ? root.next.data : -1));
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
        Node root = createBST(10, 8, 3, 12, 9);
        populateNext(root);
    }

    private static void populateNext(Node root) {
        populate(root, null);
        print(root);
    }

    private static void populate(Node node, Node parent) {
        if(node == null) return;
        populate(node.left, node);
        if(node.right != null) {
            node.next = leftMost(node.right);
        } else {
            node.next = parent;
        }
        populate(node.right, parent);
    }

    private static Node leftMost(Node root) {
        if(root == null) return null;
        if(root.left != null) return leftMost(root.left);
        return root;
    }

}
