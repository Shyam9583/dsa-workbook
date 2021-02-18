package BST;

public class FindMedianInBST {

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
        Node oddRoot = createBST(6, 3, 8, 1, 4, 7);
        System.out.println(median(oddRoot));
    }

    private static int median(Node root) {
        int size = countMorris(root);
        return medianMorris(root, size);
    }

    private static int medianInefficient(Node root) {
        State state = new State(countNodes(root));
        if ((state.len & 1) == 1) {
            findOdd(root, state);
            return state.first;
        }
        findEven(root, state);
        return (state.first + state.second) / 2;
    }

    private static void findOdd(Node root, State state) {
        if (root == null) return;
        findOdd(root.left, state);
        if (++state.position == (state.len + 1) / 2) state.first = root.data;
        findOdd(root.right, state);
    }

    private static void findEven(Node root, State state) {
        if (root == null) return;
        findEven(root.left, state);
        ++state.position;
        if (state.position == state.len / 2) state.first = root.data;
        if (state.position == state.len / 2 + 1) state.second = root.data;
        findEven(root.right, state);
    }

    private static int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int countMorris(Node root) {
        if (root == null) return 0;
        Node curr = root;
        int size = 0;
        while (curr != null) {
            if (curr.left == null) {
                size++;
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    size++;
                    curr = curr.right;
                }
            }
        }
        return size;
    }

    private static int medianMorris(Node root, int size) {
        if (root == null) return 0;
        Node curr = root;
        int position = 0;
        int first = 0, second = 0;
        while (curr != null) {
            if (curr.left == null) {
                position++;
                if (position == size / 2) first = curr.data;
                if (position == size / 2 + 1) second = curr.data;
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    position++;
                    if (position == size / 2) first = curr.data;
                    if (position == size / 2 + 1) second = curr.data;
                    curr = curr.right;
                }
            }
        }
        if ((size & 1) == 1)
            return second;
        return (first + second) / 2;
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

    private static class State {
        int first = 0, second = 0, position = 0, len;

        State(int len) {
            this.len = len;
        }
    }

}
