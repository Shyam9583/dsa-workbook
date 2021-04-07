package java.BST;

public class PredecessorAndSuccessor {

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
        Node root = createBST(75, 7, 13, 79, 91, 18, 44, 45);
        find(root, 44);
    }

    private static void find(Node root, int key) {
        Res p = new Res(), s = new Res();
        findPreSucUtil(root, p, s, key);
        int pre = p.pre != null ? p.pre.data : -1;
        int suc = s.succ != null ? s.succ.data : -1;
        System.out.println(pre + " " + suc);
    }

    private static void findPreSucUtil(Node root, Res p, Res s, int key) {
        if (root == null) return;
        if (root.data == key) {
            if (root.left != null)
                p.pre = rightMost(root.left);
            if (root.right != null)
                s.succ = leftMost(root.right);
        } else {
            if (root.data < key) {
                p.pre = root;
                findPreSucUtil(root.right, p, s, key);
            } else {
                s.succ = root;
                findPreSucUtil(root.left, p, s, key);
            }
        }
    }

    private static Node rightMost(Node root) {
        if (root == null) return null;
        if (root.right != null) return rightMost(root.right);
        return root;
    }

    private static Node leftMost(Node root) {
        if (root == null) return null;
        if (root.left != null) return leftMost(root.left);
        return root;
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

    private static class Res {
        Node pre = null, succ = null;
    }

}
