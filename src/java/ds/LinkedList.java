package java.ds;

public class LinkedList {

    Node head = null;

    public void append(int data) {
        if (head == null)
            head = new Node(data);

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void reverse() {
        Node current = head.next, prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = prev;
    }

    @Override
    public String toString() {
        if (head == null)
            return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        Node current = head.next;
        while (current != null) {
            stringBuilder.append(" ").append(current.data).append(" ");
            current = current.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
