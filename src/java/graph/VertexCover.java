package java.graph;

import java.util.ArrayList;

public class VertexCover {
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}, {5, 6}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        printVertexCover(V, adj);
    }

    private static void printVertexCover(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int u = 0; u < V; u++) {
            if (visited[u]) continue;
            for (int v : adj.get(u)) {
                if (visited[v]) continue;
                visited[u] = true;
                visited[v] = true;
                break;
            }
        }
        for (int v = 0; v < V; v++) {
            if (visited[v]) System.out.print(v + " ");
        }
    }
}
