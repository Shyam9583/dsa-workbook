package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestPathInDAG {

    private static final int INFINITY = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int V = 6, source = 1;
        int[][] edges = {{0, 1, 5}, {0, 2, 3}, {1, 3, 6}, {1, 2, 2}, {2, 4, 4}, {2, 5, 2}, {2, 3, 7}, {3, 5, 1}, {3, 4, -1}, {4, 5, -2}};
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for (int v = 0; v < V; v++) {
            adj.put(v, new HashMap<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).put(edge[1], edge[2]);
        }
        longestPath(source, V, adj);
    }

    private static void longestPath(int source, int V, Map<Integer, Map<Integer, Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, adj, visited, stack);
            }
        }
        int[] distance = new int[V];
        Arrays.fill(distance, INFINITY);
        distance[source] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (distance[u] != INFINITY) {
                for (int v : adj.get(u).keySet()) {
                    distance[v] = Math.max(distance[v], distance[u] + adj.get(u).get(v));
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println((distance[i] == INFINITY ? "INFINITY" : distance[i]) + " ");
        }
    }

    private static void topologicalSort(int u, Map<Integer, Map<Integer, Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u).keySet()) {
            if (!visited[u]) {
                topologicalSort(v, adj, visited, stack);
            }
        }
        stack.push(u);
    }
}
