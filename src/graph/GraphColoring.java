package graph;

import java.util.ArrayList;

public class GraphColoring {
    private static int max;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(chromaticNumber(graph, V));
    }

    private static int chromaticNumber(ArrayList<ArrayList<Integer>> graph, int V) {
        int[] color = new int[V];
        max = Integer.MIN_VALUE;
        recur(0, graph, color);
        return max;
    }

    private static void recur(int source, ArrayList<ArrayList<Integer>> graph, int[] color) {
        if (color[source] != 0) return;
        int currentColor = 1;
        while (isTaken(source, graph, currentColor, color)) ++currentColor;
        color[source] = currentColor;
        max = Math.max(max, currentColor);
        for (int neighbor : graph.get(source)) recur(neighbor, graph, color);
    }

    private static boolean isTaken(int source, ArrayList<ArrayList<Integer>> graph, int currentColor, int[] color) {
        for (int neighbor : graph.get(source)) {
            if (color[neighbor] == 0) continue;
            if (color[neighbor] == currentColor) return true;
        }
        return false;
    }
}
