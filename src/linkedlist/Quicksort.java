package linkedlist;

public class Quicksort {

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
        int[] arr = {4, 4, 5, 4};
        Node head = create(arr);
        head = quickSort(head);
        System.out.println(head);
    }

    private static Node quickSort(Node head) {
        if (head == null || head.next == null) return head;
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        return sort(head, end);
    }

    private static Node sort(Node start, Node end) {
        if (start == null || start.next == null || start == end)
            return start;
        Node p = partition(start, end);
        sort(start, p);
        sort(p.next, end);
        return start;
    }

    private static Node partition(Node start, Node end) {
        if (start == null || start.next == null || start == end) return start;
        int pivot = end.data;
        Node i = start, j = start, prev = i;
        while (j.next != null) {
            if (j.data < pivot) {
                swap(i, j);
                prev = i;
                i = i.next;
            }
            j = j.next;
        }
        swap(i, end);
        return prev;
    }

    private static void swap(Node a, Node b) {
        if (a != b) {
            int temp = a.data;
            a.data = b.data;
            b.data = temp;
        }
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
