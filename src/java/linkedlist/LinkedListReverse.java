package java.linkedlist;

public class LinkedListReverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6, 7, 8};
        Node head = create(arr);
        head = insert(head, 9);
        head = insert(head, 10);
        System.out.println(print(head));
        head = reverse(head);
        System.out.println(print(head));
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node current = head, prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
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

    private static String print(Node head) {
        if (head == null) return "";
        if (head.next == null) return String.valueOf(head.data);

        Node current = head.next;
        StringBuilder s = new StringBuilder();
        s.append("(").append(head.data).append(")");
        while (current != null) {
            s.append(" -> ").append("(").append(current.data).append(")");
            current = current.next;
        }
        return s.toString();
    }

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}