package java.linkedlist;

public class FindMiddleElementOfLinkedList {

    private static ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode list = create(arr);
        System.out.println(middleNode(list));
    }

    private static ListNode middleNode(ListNode head) {
        ListNode middle = head;
        int ctr = 0;
        while (head != null) {
            if ((ctr & 1) == 1)
                middle = middle.next;
            ctr++;
            head = head.next;
        }
        return middle;
    }

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int key) {
            data = key;
            next = null;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(data);
            ListNode current = next;
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
