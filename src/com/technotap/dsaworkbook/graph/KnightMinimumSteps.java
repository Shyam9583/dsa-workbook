package com.technotap.dsaworkbook.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMinimumSteps {

    private static final int[] addI = {-2, -2, -1, -1, 2, 2, 1, 1};
    private static final int[] addJ = {-1, 1, -2, 2, -1, 1, -2, 2};

    public static void main(String[] args) {
        int N = 6;
        int[] knightPos = {4, 5}, targetPos = {1, 1};
        System.out.println(minimumSteps(knightPos, targetPos, N));
    }

    private static int minimumSteps(int[] knightPos, int[] targetPos, int N) {
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) return 0;
        int steps = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(knightPos[0], knightPos[1]));
        while (!q.isEmpty()) {
            int size = q.size();
            ++steps;
            for (int i = 0; i < size; i++) {
                Position curr = q.remove();
                if (visited[curr.i - 1][curr.j - 1]) continue;
                visited[curr.i - 1][curr.j - 1] = true;
                for (int idx = 0; idx < 8; idx++) {
                    int ni = curr.i + addI[idx], nj = curr.j + addJ[idx];
                    if (ni < 1 || ni > N || nj < 1 || nj > N || visited[ni - 1][nj - 1]) continue;
                    if (ni == targetPos[0] && nj == targetPos[1]) return steps;
                    q.add(new Position(ni, nj));
                }
            }
        }
        return steps;
    }

    private static class Position {
        int i, j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
