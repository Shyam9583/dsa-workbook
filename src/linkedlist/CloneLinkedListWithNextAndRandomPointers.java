package linkedlist;

import java.util.HashMap;

public class CloneLinkedListWithNextAndRandomPointers {

    private static Node create(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static Node get(Node head, int position) {
        int count = 1;
        while (head != null && count++ < position) head = head.next;
        return head;
    }

    private static void setRandom(Node head, int position, int randomPosition) {
        Node target = get(head, position);
        target.arb = get(head, randomPosition);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = create(arr);
        setRandom(head, 1, 2);
        setRandom(head, 2, 4);
        System.out.println(head);
        Node clone = cloneEfficiently(head);
        System.out.println(clone);
        System.out.println(head);
    }

    private static Node clone(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        for (Node curr = head; curr != null; curr = curr.next)
            map.putIfAbsent(curr, new Node(curr.data));

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.next != null) {
                map.get(curr).next = map.get(curr.next);
            }
            if (curr.arb != null) {
                map.get(curr).arb = map.get(curr.arb);
            }
        }
        return map.get(head);
    }

    private static Node cloneEfficiently(Node head) {
        if (head == null) return null;
        for (Node curr = head; curr != null; curr = curr.next) {
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr = curr.next;
            curr.next = next;
        }
        Node newHead = head.next;
        for (Node curr = head; curr != null; curr = curr.next.next) {
            if (curr.arb != null)
                curr.next.arb = curr.arb.next;
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            Node copy = curr.next;
            curr.next = curr.next.next;
            if (copy.next != null)
                copy.next = copy.next.next;
        }
        return newHead;
    }

    private static class Node {
        int data;
        Node next, arb;

        Node(int key) {
            data = key;
            next = null;
            arb = null;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(data);
            Node current = next;
            StringBuilder s = new StringBuilder();
            s.append("(").append(hashCode()).append(" [").append(data).append(", ").append(arb != null ? arb.data : null).append("]").append(")");
            while (current != null) {
                s.append(" -> ").append("(").append(current.hashCode()).append(" [").append(current.data).append(",").append(current.arb != null ? current.arb.data : null).append("]").append(")");
                current = current.next;
            }
            return s.toString();
        }
    }
}
