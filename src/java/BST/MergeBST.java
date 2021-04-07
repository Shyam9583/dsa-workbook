package java.BST;

import java.util.ArrayList;

public class MergeBST {

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
        Node root1 = createBST(100, 50, 300, 20, 70);
        Node root2 = createBST(80, 40, 120);
        Node mergedRoot = merge(root1, root2);
        print(mergedRoot);
    }

    private static Node merge(Node root1, Node root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return mergeInPlace(root1, root2);
    }

    private static Node mergeWithArrays(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);
        return createBSTFromList(mergedList, 0, mergedList.size() - 1);
    }

    private static Node createBSTFromList(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBSTFromList(list, start, mid - 1);
        root.right = createBSTFromList(list, mid + 1, end);
        return root;
    }

    private static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> first, ArrayList<Integer> second) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < first.size() && j < second.size()) {
            if (first.get(i) <= second.get(j)) {
                result.add(first.get(i++));
            } else {
                result.add(second.get(j++));
            }
        }
        while (i < first.size()) result.add(first.get(i++));
        while (j < second.size()) result.add(second.get(j++));
        return result;
    }

    private static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    private static Node mergeInPlace(Node root1, Node root2) {
        DLLState state1 = new DLLState(), state2 = new DLLState();
        convertBSTToDLL(root1, state1);
        convertBSTToDLL(root2, state2);
        Node mergedDLL = mergeDLLs(state1.head, state2.head);
        return convertDLLtoBST(mergedDLL);
    }

    private static void convertBSTToDLL(Node root, DLLState state) {
        if (root == null) return;
        convertBSTToDLL(root.left, state);
        if (state.prev == null) {
            state.head = root;
        } else {
            root.left = state.prev;
            state.prev.right = root;
        }
        state.prev = root;
        convertBSTToDLL(root.right, state);
    }

    private static Node convertDLLtoBST(Node head) {
        int length = 0;
        for (Node curr = head; curr != null; curr = curr.right) length++;
        return convertDLLtoBSTUtil(new Node[]{head}, length);
    }

    private static Node convertDLLtoBSTUtil(Node[] head, int n) {
        if (n <= 0) return null;
        Node left = convertDLLtoBSTUtil(head, n / 2);
        Node root = head[0];
        root.left = left;
        head[0] = head[0].right;
        root.right = convertDLLtoBSTUtil(head, n - n / 2 - 1);
        return root;
    }

    private static Node mergeDLLs(Node head1, Node head2) {
        Node result = new Node(-1);
        Node ptr = result;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                ptr.right = head1;
                head1.left = ptr;
                head1 = head1.right;
            } else {
                ptr.right = head2;
                head2.left = ptr;
                head2 = head2.right;
            }
            ptr = ptr.right;
        }
        while (head1 != null) {
            ptr.right = head1;
            head1.left = ptr;
            head1 = head1.right;
            ptr = ptr.right;
        }
        while (head2 != null) {
            ptr.right = head2;
            head2.left = ptr;
            head2 = head2.right;
            ptr = ptr.right;
        }
        return result.right;
    }

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

    private static class DLLState {
        Node head = null, prev = null;
    }

}
