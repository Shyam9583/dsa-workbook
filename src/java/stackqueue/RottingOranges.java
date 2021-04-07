package java.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2, 2, 0, 1}};
        System.out.println(minTime(grid));
    }

    private static int minTime(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int time = -1;
        Queue<Orange> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) q.add(new Orange(i, j));
            }
        }
        while (!q.isEmpty()) {
            q.add(new Orange());
            while (!q.isEmpty() && !q.peek().isDelimiter) {
                Orange orange = q.remove();
                addAdjacent(grid, q, orange.i, orange.j);
            }
            time++;
            q.remove();
        }
        for (int[] ints : grid) {
            for (int orange : ints) {
                if (orange == 1) return -1;
            }
        }
        return time;
    }

    private static void addAdjacent(int[][] grid, Queue<Orange> q, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            q.add(new Orange(i - 1, j));
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            q.add(new Orange(i + 1, j));
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            q.add(new Orange(i, j - 1));
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            q.add(new Orange(i, j + 1));
        }
    }

    private static class Orange {
        int i, j;
        boolean isDelimiter;

        Orange(int i, int j) {
            this.i = i;
            this.j = j;
            this.isDelimiter = false;
        }

        Orange() {
            i = j = -1;
            isDelimiter = true;
        }
    }
}
