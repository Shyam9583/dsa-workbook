package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}
        };
        System.out.println(merge(arrays, arrays.length));
    }

    private static ArrayList<Integer> merge(int[][] arrays, int k) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] ptr = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap.add(new Entry(i, arrays[i][0]));
        }
        while (!minHeap.isEmpty()) {
            Entry min = minHeap.remove();
            result.add(min.val);
            if (++ptr[min.idx] < k) {
                minHeap.add(new Entry(min.idx, arrays[min.idx][ptr[min.idx]]));
            }
        }
        return result;
    }

    private static class Entry implements Comparable<Entry> {
        int idx, val;

        Entry(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Entry o) {
            if (val == o.val) return idx - o.idx;
            return val - o.val;
        }
    }
}
