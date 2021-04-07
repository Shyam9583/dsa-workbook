package java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 10;
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        System.out.println(dfs(1, V, adj));
        System.out.println(dfs(2, V, adj));
    }

    private static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            result.add(node);
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return result;
    }

    private static ArrayList<Integer> dfs(int source, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfsUtil(source, adj, result, visited);
        return result;
    }

    private static void dfsUtil(int source, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, boolean[] visited) {
        visited[source] = true;
        result.add(source);
        for (int node : adj.get(source)) {
            if (!visited[node]) dfsUtil(node, adj, result, visited);
        }
    }
}
