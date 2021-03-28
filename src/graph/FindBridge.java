package graph;

import java.util.ArrayList;

public class FindBridge {

    private static int time;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}};
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(findBridges(V, adj));
    }

    private static ArrayList<Edge> findBridges(int V, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        ArrayList<Edge> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            disc[i] = low[i] = parent[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) DFS(i, adj, result, disc, low, parent);
        }
        return result;
    }

    private static void DFS(int current, ArrayList<ArrayList<Integer>> adj, ArrayList<Edge> result, int[] disc, int[] low, int[] parent) {
        disc[current] = low[current] = time++;
        for (int neighbor : adj.get(current)) {
            if (disc[neighbor] == -1) {
                parent[neighbor] = current;
                DFS(neighbor, adj, result, disc, low, parent);
                low[current] = Math.min(low[current], low[neighbor]);
                if (low[neighbor] > disc[current]) {
                    result.add(new Edge(current, neighbor));
                }
            } else if (neighbor != parent[current]) {
                low[current] = Math.min(low[current], low[neighbor]);
            }
        }
    }

    private static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    '}';
        }
    }

}
