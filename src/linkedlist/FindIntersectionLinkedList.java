package linkedlist;

import java.util.HashMap;

public class FindIntersectionLinkedList {

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
        int[] L1 = {1, 3, 7, 8, 9};
        int[] L2 = {3, 5, 9, 9, 13, 14, 16};
        System.out.println(intersectionSortedList(create(L1), create(L2)));
    }

    private static Node intersection(Node A, Node B) {
        HashMap<Integer, Object> mapA = new HashMap<>();
        HashMap<Integer, Object> mapB = new HashMap<>();
        Node dummy = new Node(-1);
        Node i = dummy;
        Node curr = A;
        while (curr != null) {
            mapA.putIfAbsent(curr.data, new Object());
            curr = curr.next;
        }
        curr = B;
        while (curr != null) {
            if (mapA.containsKey(curr.data) && !mapB.containsKey(curr.data)) {
                i.next = new Node(curr.data);
                i = i.next;
            }
            mapB.putIfAbsent(curr.data, new Object());
            curr = curr.next;
        }

        return dummy.next;
    }

    private static Node intersectionSortedList(Node A, Node B) {
        Node left = A, right = B;
        Node dummy = new Node(-1);
        Node i = dummy;
        while (left != null && right != null) {
            if (left.data == right.data) {
                i.next = new Node(left.data);
                i = i.next;
                left = left.next;
                right = right.next;
            } else if (left.data < right.data) {
                left = left.next;
            } else {
                right = right.next;
            }
        }
        return removeDuplicates(dummy.next);
    }

    private static Node removeDuplicates(Node head) {
        if (head == null) return null;
        Node prev = head;
        while (prev != null) {
            Node curr = prev.next;
            while (curr != null && curr.data == prev.data) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
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
