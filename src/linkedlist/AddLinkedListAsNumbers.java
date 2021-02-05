package linkedlist;

public class AddLinkedListAsNumbers {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3}, arr2 = {9, 9, 9, 9};
        Node a = create(arr1), b = create(arr2);
        Node c = add(a, b);
        System.out.println(c);
    }

    private static Node add(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        int result, remainder = 0;
        Node newHead = new Node(-1);
        Node curr = newHead;
        Node left = first, right = second;
        while (left != null && right != null) {
            int r = (left.data + right.data + remainder);
            result = r % 10;
            remainder = r / 10;
            curr.next = new Node(result);
            curr = curr.next;
            left = left.next;
            right = right.next;
        }
        while (left != null) {
            int r = (left.data + remainder);
            result = r % 10;
            remainder = r / 10;
            curr.next = new Node(result);
            curr = curr.next;
            left = left.next;
        }
        while (right != null) {
            int r = (right.data + remainder);
            result = r % 10;
            remainder = r / 10;
            curr.next = new Node(result);
            curr = curr.next;
            right = right.next;
        }
        curr.next = remainder > 0 ? new Node(remainder) : null;
        return reverse(newHead.next);
    }

    private static Node reverse(Node head) {
        if (head == null) return null;
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(data);
            Node current = next;
            StringBuilder s = new StringBuilder();
            s.append("(").append(data).append(")");
            while (current != null) {
                s.append(" -> ").append("(").append(current.data).append(")");
                current = current.next;
            }
            return s.toString();
        }
    }
}
