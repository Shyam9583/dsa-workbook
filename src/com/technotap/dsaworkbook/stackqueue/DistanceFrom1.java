package com.technotap.dsaworkbook.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceFrom1 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        int[][] result = nearest(grid);
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static int[][] nearest(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) q.add(new Cell(i, j));
            }
        }
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell cell = q.remove();
                result[cell.i][cell.j] = distance;
                process(grid, q, cell.i, cell.j);
            }
            distance++;
        }
        return result;
    }

    private static void process(int[][] grid, Queue<Cell> q, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == 0) {
            grid[i - 1][j] = 1;
            q.add(new Cell(i - 1, j));
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 0) {
            grid[i + 1][j] = 1;
            q.add(new Cell(i + 1, j));
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 0) {
            grid[i][j - 1] = 1;
            q.add(new Cell(i, j - 1));
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
            grid[i][j + 1] = 1;
            q.add(new Cell(i, j + 1));
        }
    }

    private static class Cell {
        int i, j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
