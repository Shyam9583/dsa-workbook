package com.technotap.dsaworkbook.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{4, 1}, {4, 0}, {1, 3}, {2, 3}, {5, 2}, {5, 0}};
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        System.out.println(Arrays.toString(topologicalSort(V, adj)));
    }

    private static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        int[] result = new int[V];
        int ptr = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) inDegree[node]++;
        }
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            result[ptr++] = node;
            for (int neighbor : adj.get(node)) {
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return ptr == V ? result : new int[]{};
    }
}
