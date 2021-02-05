package linkedlist;

public class SortLinkedListWith012 {

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
        int[] arr = {2, 2, 0, 1};
        Node head = create(arr);
        System.out.println(head);
        head = sort(head);
        System.out.println(head);
    }

    private static Node sort(Node head) {
        int[] count = new int[3];
        Node temp = new Node(-1);
        while (head != null) {
            count[head.data]++;
            head = head.next;
        }
        head = temp;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                head.next = new Node(i);
                head = head.next;
            }
        }
        return temp.next;
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
