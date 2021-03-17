package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestRangeInKLists {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7, 9},
                {0, 2, 4, 6, 8},
                {2, 3, 5, 7, 11}
        };
        System.out.println(Arrays.toString(findSmallestRange(arr, arr[0].length, arr.length)));
    }

    private static int[] findSmallestRange(int[][] arr, int n, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, range = Integer.MAX_VALUE;
        int[] ptr = new int[k];
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < k; i++) {
            int item = arr[i][0];
            heap.add(new Node(i, item));
            if (max < item) max = item;
        }
        int start = min, end = max;
        while (!heap.isEmpty()) {
            Node root = heap.remove();
            min = root.val;
            if (max - min < range) {
                range = max - min;
                start = min;
                end = max;
            }
            if (++ptr[root.idx] == n) break;
            Node next = new Node(root.idx, ptr[root.idx]);
            if (max < next.val) max = next.val;
            heap.add(next);
        }
        return new int[]{start, end};
    }

    private static class Node {
        int idx, val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
