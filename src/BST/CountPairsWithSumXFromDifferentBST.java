package BST;

public class CountPairsWithSumXFromDifferentBST {

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
        Node root1 = createBST(426, 690, 272, 159, 511, 164, 614, 322, 773);
        Node root2 = createBST(676, 382, 375 );
        System.out.println(countPairs(root1, root2, 426));
    }

    private static int countPairs(Node root1, Node root2, int x) {
        if(root1 == null || root2 == null) return 0;
        int result = countPairs(root1.left, root2, x) + countPairs(root1.right, root2, x);
        return result + (contains(root2, x - root1.data) ? 1 : 0);
    }

    private static boolean contains(Node root, int value) {
        if(root == null) return false;
        if(root.data == value) return true;
        if(value < root.data) return contains(root.left, value);
        return contains(root.right, value);
    }

}
