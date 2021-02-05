package linkedlist;

public class Add1ToTheLinkedList {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        Node head = create(arr);
        System.out.println(head);
        head = result(head);
        System.out.println(head);
    }

    private static Node result(Node head) {
        if (head == null) return null;
        int add = 1, remainder;
        head = reverse(head);
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            int q = (curr.data + add) / 10;
            remainder = (curr.data + add) % 10;
            add = q;
            curr.data = remainder;
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = prev.data == 0 ? new Node(1) : null;
        }
        return reverse(head);
    }

    private static Node insert(Node head, int data) {
        if (head != null) {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = new Node(data);
        } else {
            head = new Node(data);
        }
        return head;
    }

    private static int count(Node head) {
        if (head == null) return 0;
        Node curr = head;
        int result = 0;
        while (curr != null) {
            result++;
            curr = curr.next;
        }
        return result;
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
