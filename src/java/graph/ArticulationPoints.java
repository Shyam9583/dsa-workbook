package java.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoints {

    private static int time;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 8;
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {0, 4}, {1, 5}, {2, 1}, {2, 6}, {2, 3}, {3, 6}, {4, 0}, {4, 5}, {5, 2}, {5, 6}, {6, 7}, {7, 3}};
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);
        System.out.println(Arrays.toString(articulationPoints(V, graph)));
    }

    private static boolean[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        int[] disc = new int[V];
        int[] parent = new int[V];
        int[] low = new int[V];
        boolean[] AP = new boolean[V];
        for (int i = 0; i < V; i++) {
            disc[i] = parent[i] = low[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, adj, disc, parent, low, AP);
            }
        }
        return AP;
    }

    private static void dfs(int current, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] parent, int[] low, boolean[] AP) {
        disc[current] = low[current] = time++;
        int children = 0;
        for (int neighbor : adj.get(current)) {
            if (disc[neighbor] == -1) {
                children++;
                parent[neighbor] = current;
                dfs(neighbor, adj, disc, parent, low, AP);
                low[current] = Math.min(low[current], low[neighbor]);
                if (parent[current] == -1 && children > 1 || parent[current] != -1 && low[neighbor] >= disc[current]) {
                    AP[current] = true;
                }
            } else if (neighbor != parent[current]) {
                low[current] = Math.min(low[current], low[neighbor]);
            }
        }
    }

}
