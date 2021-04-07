package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) {
        int[] boards = {10, 10, 10, 10};
        int nPainters = 2;
        System.out.println(minimize(boards, boards.length, nPainters));
    }

    private static int minimize(int[] boards, int size, int nPainters) {
        Arrays.sort(boards);
        int low = boards[size - 1], high = Arrays.stream(boards).sum(), best = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int neededPainters = 1, sum = 0;
            for (int i = 0; i < size; i++) {
                if (sum + boards[i] > mid) {
                    neededPainters++;
                    sum = boards[i];
                } else {
                    sum += boards[i];
                }
            }
            if (neededPainters > nPainters) {
                low = mid + 1;
            } else {
                if (best > mid)
                    best = mid;
                high = mid - 1;
            }
        }
        return best;
    }
}
