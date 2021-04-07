package com.technotap.dsaworkbook.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = {{-1, -1, 19, 10, -1}, {2, -1, -1, 6, -1}, {-1, 17, -1, 19, -1}, {25, -1, 20, -1, -1}, {-1, -1, -1, -1, 15}};
        System.out.println(snakesAndLadders(board));
    }

    private static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int x = queue.remove();
                if (x == n * n) return steps;
                for (int i = 1; i <= 6; i++) {
                    if (x + i > n * n) break;
                    int[] pos = coordinate(x + i, n);
                    int r = pos[0], c = pos[1];
                    if (visited[r][c]) continue;
                    visited[r][c] = true;
                    if (board[r][c] == -1) {
                        queue.add(x + i);
                    } else {
                        queue.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static int[] coordinate(int number, int n) {
        int r = n - ((number - 1) / n) - 1;
        int c = (number - 1) % n;
        if ((r & 1) == (n & 1)) {
            c = (n - 1) - c;
        }
        return new int[]{r, c};
    }
}
