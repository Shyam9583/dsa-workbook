package graph;

import java.util.ArrayList;
import java.util.List;

public class MColoring {
    public static void main(String[] args) {
        int N = 3, M = 2;
        ArrayList<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        int[][] edges = {{1, 2}, {2, 3}, {1, 3}};
        for (int[] edge : edges) {
            G[edge[0] - 1].add(edge[1] - 1);
            G[edge[1] - 1].add(edge[0] - 1);
        }
        int[] color = new int[N];
        System.out.println(graphColoring(G, color, 0, M));
    }

    private static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        if (i == G.length) return true;
        for (int c = 1; c <= C; c++) {
            if (isInvalid(G[i], color, c)) continue;
            color[i] = c;
            if (graphColoring(G, color, i + 1, C)) return true;
            color[i] = 0;
        }
        return false;
    }

    private static boolean isInvalid(List<Integer> neighbors, int[] color, int c) {
        for (int neighbor : neighbors) {
            if (color[neighbor] == c) return true;
        }
        return false;
    }
}
