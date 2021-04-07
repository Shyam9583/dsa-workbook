package com.technotap.dsaworkbook.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumEdgesToReverseToReachDestination {

    private static final int INFINITY = 1 << 16;

    public static void main(String[] args) {
        int V = 7, src = 0, dst = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int v = 0; v < V; v++) adj.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {2, 1}, {2, 3}, {6, 3}, {6, 4}, {4, 5}, {5, 1}};
        for (int[] e : edges) adj.get(e[0]).add(e[1]);
        System.out.println(minEdgesToReverse(src, dst, V, adj));
    }

    private static int minEdgesToReverse(int src, int dst, int V, ArrayList<ArrayList<Integer>> adj) {
        // Make a new Graph using reverse edges
        ArrayList<Map<Integer, Integer>> G = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            G.add(new HashMap<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                G.get(u).put(v, 0);
                G.get(v).put(u, 1);
            }
        }
        // Djikstra
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, INFINITY);
        distance[src] = 0;
        for (int i = 0; i < V; i++) {
            int curr = nextNode(distance, visited);
            visited[curr] = true;
            for (int neighbor : G.get(curr).keySet()) {
                distance[neighbor] = Math.min(distance[curr] + G.get(curr).get(neighbor), distance[neighbor]);
            }
        }
        return distance[dst];
    }

    private static int nextNode(int[] distance, boolean[] visited) {
        int minIndex = 0, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (visited[i]) continue;
            if (minValue > distance[i]) {
                minIndex = i;
                minValue = distance[i];
            }
        }
        return minIndex;
    }
}
