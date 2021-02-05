package linkedlist;

import java.util.HashMap;

public class RemoveDuplicatesFromUnsortedLinkedList {
    public static void main(String[] args) {
        int[] list = {5, 1, 4, 5, 2, 2, 5, 4, 3, 2};
        Node head = create(list);
        System.out.println(head);
        head = removeDuplicate(head);
        System.out.println(head);
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

    private static Node removeDuplicate(Node head) {
        if (head == null) return null;
        Node current = head;
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(current.data, true);
        while (current != null) {
            current.next = next(current.next, map);
            current = current.next;
        }
        return head;
    }

    private static Node next(Node current, HashMap<Integer, Boolean> map) {
        if (current == null) return null;
        if (map.containsKey(current.data))
            return next(current.next, map);
        else {
            map.put(current.data, true);
            return current;
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
