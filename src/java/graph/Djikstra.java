package java.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Djikstra {
    public static void main(String[] args) {
        Graph graph = getGraph();
        int N = 9;
        System.out.println(Arrays.toString(minDistance(graph, N)));
    }

    private static Graph getGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        return graph;
    }

    private static int[] minDistance(Graph graph, int N) {
        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];
        result[0] = 0;
        int curr = 0;
        for (int i = 0; i < N; i++) {
            visited[curr] = true;
            Map<Integer, Integer> edges = graph.getNeighbors(curr);
            int min = Integer.MAX_VALUE, next = curr;
            for (int neighbor : edges.keySet()) {
                int distance = result[curr] + edges.get(neighbor);
                if (distance < result[neighbor]) {
                    result[neighbor] = distance;
                }
                if (min > result[neighbor] && !visited[neighbor]) {
                    min = result[neighbor];
                    next = neighbor;
                }
            }
            curr = next;
        }
        return result;
    }

    private static class Graph {
        private final Map<Integer, Map<Integer, Integer>> adj;

        Graph() {
            adj = new HashMap<>();
        }

        void addEdge(int u, int v, int weight) {
            adj.putIfAbsent(u, new HashMap<>());
            adj.putIfAbsent(v, new HashMap<>());
            adj.get(u).put(v, weight);
            adj.get(v).put(u, weight);
        }

        Map<Integer, Integer> getNeighbors(int node) {
            return adj.get(node);
        }
    }
}
