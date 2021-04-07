package com.technotap.dsaworkbook.dynamicprogramming;

public class GoldMine {
    public static void main(String[] args) {
        int[][] mine = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        System.out.println(maxGold(mine, mine.length, mine[0].length));
    }

    private static int maxGold(int[][] mine, int r, int c) {
        int[] next = new int[r], curr = new int[r], temp;
        for (int i = 0; i < r; i++) {
            curr[i] = mine[i][c - 1];
        }
        for (int j = c - 2; j >= 0; j--) {
            temp = curr;
            curr = next;
            next = temp;
            for (int i = 0; i < r; i++) {
                curr[i] = Math.max(getNext(next, i - 1),
                        Math.max(getNext(next, i), getNext(next, i + 1))) + mine[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int val : curr) max = Math.max(max, val);
        return max;
    }

    private static int getNext(int[] next, int i) {
        if (i < 0 || i == next.length) return 0;
        return next[i];
    }
}
