package linkedlist;

public class CheckForPalindromicLinkedList {

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
        Node test1 = create(new int[]{1, 2, 1});
        Node test2 = create(new int[]{1, 2, 3, 4});
        Node test3 = create(new int[]{5});
        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));
    }

    private static boolean isPalindrome(Node head) {
        Node mid = middle(head);
        Node left = head, right = reverse(mid.next);
        mid.next = null;
        while (left != null && right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static Node middle(Node head) {
        Node mid = head, end = head;
        int ctr = 0;
        while (end.next != null) {
            if ((ctr & 1) == 1)
                mid = mid.next;
            ctr++;
            end = end.next;
        }
        return mid;
    }

    private static Node reverse(Node head) {
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
