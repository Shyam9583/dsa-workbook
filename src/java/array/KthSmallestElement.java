package java.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) throws IllegalStateException {
        int[][] matrix = {
                {16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94}
        };

//        int[] positions = {3, 6, 7, 9, 16, 17};
//
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
//
//        for(int position: positions) {
//            System.out.println("Position = (" + position + ") => (" + kthSmallest(matrix, matrix.length, matrix[0].length, position, minHeap) + ")");
//        }

        System.out.println(kthSmallest(matrix, matrix.length, matrix[0].length, 16, minHeap));
    }

    private static int kthSmallest(int[][] matrix, int m, int n, int k, PriorityQueue<Entry> heap) {
        int kthSmallest = matrix[0][0];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            heap.add(new Entry(0, i, matrix[0][i]));
        }
        while (counter++ < k) {
            Entry root = heap.poll();
            if (root != null) {
                int nextVal = root.row < m - 1 ? matrix[root.row + 1][root.column] : Integer.MAX_VALUE;
                kthSmallest = root.value;
                heap.add(new Entry(root.row + 1, root.column, nextVal));
            }
        }
        return kthSmallest;
    }

    private static class Entry {
        int row, column, value;

        Entry(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
