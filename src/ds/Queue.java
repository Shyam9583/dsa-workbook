package ds;

public class Queue {

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (tail != null)
            tail.next = node;
        tail = node;
        if (head == null)
            head = node;
    }

    public int peek() throws Exception {
        if (head == null) throw new Exception("Queue is empty");
        return head.data;
    }

    public int remove() throws Exception {
        if (head == null) throw new Exception("Queue is empty");
        int data = head.data;
        head = head.next;
        return data;
    }

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

}
