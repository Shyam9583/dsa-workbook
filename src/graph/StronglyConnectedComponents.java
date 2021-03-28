package graph;

import java.util.ArrayList;

public class StronglyConnectedComponents {

    private static int countSsc, time;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {0, 4}, {1, 5}, {2, 1}, {2, 6}, {2, 3}, {3, 6}, {4, 0}, {4, 5}, {5, 2}, {5, 6}, {6, 7}, {7, 3}};
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);
        System.out.println(numberOfSSC(V, adj));
    }

    private static int numberOfSSC(int V, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        countSsc = 0;
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            disc[i] = low[i] = parent[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) DFS(i, adj, disc, low, parent);
        }
        return countSsc;
    }

    private static void DFS(int current, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, int[] parent) {
        disc[current] = low[current] = time++;
        for (int neighbor : adj.get(current)) {
            if (disc[neighbor] == -1) {
                parent[neighbor] = current;
                DFS(neighbor, adj, disc, low, parent);
                low[current] = Math.min(low[current], low[neighbor]);
            } else if (neighbor != parent[current]) {
                low[current] = Math.min(low[current], low[neighbor]);
            }
        }
        if (low[current] == disc[current]) countSsc++;
    }
}
