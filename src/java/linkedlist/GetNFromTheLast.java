package java.linkedlist;

public class GetNFromTheLast {

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = create(arr);
        int n = 2;
        System.out.println(getNthFromLast(head, n));
    }

    private static int getNthFromLast(Node head, int n) {
        if (head == null) return -1;
        int length = 0;
        for (Node curr = head; curr != null; curr = curr.next) length++;
        if (n > length)
            return -1;
        int pos = length - n;
        while (pos-- > 0) head = head.next;
        return head.data;
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
