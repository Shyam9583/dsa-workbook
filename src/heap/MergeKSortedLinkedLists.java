package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        Node[] arr = {create(1, 2, 3), create(4, 5), create(5, 6), create(7, 8)};
        Node result = merge(arr, arr.length);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    private static Node create(int... arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static Node merge(Node[] arr, int k) {
        Node result = new Node(-1);
        Node curr = result;
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.data));
        heap.addAll(Arrays.asList(arr));
        while (!heap.isEmpty()) {
            Node top = heap.remove();
            curr.next = top;
            curr = curr.next;
            if (top.next == null) continue;
            heap.add(top.next);
        }
        return result.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
