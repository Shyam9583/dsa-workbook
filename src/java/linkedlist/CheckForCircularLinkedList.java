package java.linkedlist;

public class CheckForCircularLinkedList {

    private static Node create(int[] arr, boolean makeCircular) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        if (makeCircular)
            curr.next = head;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node list = create(arr, true);
        System.out.println(isCircular(list));
        list = create(arr, false);
        System.out.println(isCircular(list));
    }

    private static boolean isCircular(Node head) {
        if (head == null || head.next == null) return false;
        Node curr = head;
        while (curr.next != null && curr.next != head) curr = curr.next;
        return curr.next != null;
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
