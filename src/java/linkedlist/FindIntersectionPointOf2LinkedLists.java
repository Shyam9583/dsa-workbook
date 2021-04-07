package java.linkedlist;

public class FindIntersectionPointOf2LinkedLists {

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
        int[] L1 = {39, 9, 31, 22, 82, 6, 18, 15, 91};
        int[] L2 = {80, 72};

        Node H1 = create(L1);
        Node H2 = create(L2);

        int index = 6;

        H2 = insert(H2, getNode(H1, index));

        System.out.println(intersectionPoint(H1, H2));
    }

    private static int intersectionPoint(Node A, Node B) {
        Node d1 = A, d2 = B;
        while (d1 != d2) {
            d1 = d1 == null ? B : d1.next;
            d2 = d2 == null ? A : d2.next;
        }
        if (d1 == null)
            return -1;
        return d1.data;
    }

    private static Node getNode(Node head, int index) {
        int count = 0;
        Node current = head;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current;
    }

    private static Node insert(Node head, Node next) {
        if (head != null) {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = next;
        } else {
            head = next;
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
