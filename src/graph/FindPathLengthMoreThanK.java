package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindPathLengthMoreThanK {
    public static void main(String[] args) {
        int n = 10, src = 1, k = 23;
        int[][] edges = {
                {1, 2, 1}, {2, 3, 2}, {2, 5, 5},
                {3, 4, 2}, {4, 7, 3}, {4, 8, 4},
                {5, 6, 2}, {6, 7, 1}, {7, 10, 2},
                {8, 9, 5}, {9, 10, 1}
        };
        ArrayList<Map<Integer, Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new HashMap<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).put(edge[1], edge[2]);
            adj.get(edge[1]).put(edge[0], edge[2]);
        }
        System.out.println(containsPath(src, adj, k));
    }

    private static boolean containsPath(int src, ArrayList<Map<Integer, Integer>> adj, int k) {
        boolean[] visited = new boolean[adj.size()];
        return backtracking(src, adj, k, visited, 0);
    }

    private static boolean backtracking(int src, ArrayList<Map<Integer, Integer>> adj, int k, boolean[] visited, int length) {
        if (length > k) return true;
        visited[src] = true;
        Map<Integer, Integer> neighbors = adj.get(src);
        for (int neighbor : neighbors.keySet()) {
            if (visited[neighbor]) continue;
            if (backtracking(neighbor, adj, k, visited, length + neighbors.get(neighbor)))
                return true;
        }
        visited[src] = false;
        return false;
    }
}
