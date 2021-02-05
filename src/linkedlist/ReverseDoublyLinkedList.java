package linkedlist;

public class ReverseDoublyLinkedList {
    private static Node createList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head, prev;
        for (int i = 1; i < arr.length; i++) {
            prev = curr;
            curr.next = new Node(arr[i]);
            curr = curr.next;
            curr.prev = prev;
        }
        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != null);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = createList(arr);
        printList(head);
        head = reverse(head);
        printList(head);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            newHead = push(newHead, head);
            head = next;
        }
        return newHead;
    }

    private static Node push(Node head, Node newNode) {
        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        return newNode;
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
