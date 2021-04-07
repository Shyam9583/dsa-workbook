package java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphDisconnected {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {1, 0}, {1, 2}, {2, 1}, {2, 3}, {3, 0}, {3, 2}};
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int v = 0; v < V; v++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);
        System.out.println(isBipartite(V, adj));
    }

    private static boolean isBipartiteUtil(int source, ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int neighbor : adj.get(node)) {
                if (neighbor == node) return false;
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int v = 0; v < V; v++) {
            if (color[v] == -1) {
                if (!isBipartiteUtil(v, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
