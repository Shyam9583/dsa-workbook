package com.technotap.dsaworkbook.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MColoringProblem {
    public static void main(String[] args) {
        int N = 3, M = 2;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        List<Integer>[] G = new ArrayList[N];
        IntStream.range(0, N).forEach(i -> G[i] = new ArrayList<>());
        for (int[] e : edges) {
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }
        System.out.println(graphColoring(G, new int[N], 0, M));
    }

    private static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        if (i == G.length) return true;
        for (int c = 1; c <= C; c++) {
            if (!isValidColor(G[i], color, c)) continue;
            color[i] = c;
            if (graphColoring(G, color, i + 1, C))
                return true;
            color[i] = 0;
        }
        return false;
    }

    private static boolean isValidColor(List<Integer> adj, int[] color, int c) {
        for (int adjNode : adj) {
            if (color[adjNode] == c) return false;
        }
        return true;
    }
}
