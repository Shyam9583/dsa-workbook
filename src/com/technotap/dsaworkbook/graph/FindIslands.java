package com.technotap.dsaworkbook.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindIslands {

    private static final int[] addI = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] addJ = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        char[][] grid = {{'0', '1'}, {'1', '0'}, {'1', '1'}, {'1', '0'}};
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int N = grid.length, M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') queue.add(new Position(i, j));
            }
        }
        int color = 0;
        while (!queue.isEmpty()) {
            Position curr = queue.remove();
            if (visited[curr.i][curr.j]) continue;
            ++color;
            dfs(grid, visited, curr.i, curr.j, N, M);
        }
        return color;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        for (int dir = 0; dir < 8; dir++) {
            dfs(grid, visited, i + addI[dir], j + addJ[dir], N, M);
        }
    }

    private static class Position {
        int i, j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
