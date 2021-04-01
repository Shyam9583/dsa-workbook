package graph;

import java.util.*;

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
        int[] topological = topologicalSort(V, adj);
        int[] longestPath = new int[V];
        Arrays.fill(longestPath, INFINITY);
        longestPath[source] = 0;
        for (int node : topological) {
            for (int neighbor : adj.get(node).keySet()) {
                int newPathLength = longestPath[node] + adj.get(node).get(neighbor);
                if (newPathLength > longestPath[neighbor]) {
                    longestPath[neighbor] = newPathLength;
                }
            }
        }
        for (int length : longestPath) {
            System.out.print((length == INFINITY ? "INFINITY" : length) + " ");
        }
    }

    private static int[] topologicalSort(int V, Map<Integer, Map<Integer, Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        int[] result = new int[V];
        int ptr = 0;
        for (int node : adj.keySet()) {
            for (int neighbor : adj.get(node).keySet()) {
                inDegree[neighbor]++;
            }
        }
        for (int v = 0; v < V; v++) {
            if (inDegree[v] == 0) q.add(v);
        }
        while (!q.isEmpty()) {
            int current = q.remove();
            result[ptr++] = current;
            Map<Integer, Integer> neighbors = adj.get(current);
            for (int neighbor : neighbors.keySet()) {
                if (--inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return result;
    }
}
