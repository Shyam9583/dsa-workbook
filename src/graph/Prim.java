package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Prim {
    public static void main(String[] args) {
        Graph graph = getGraph();
        int V = 9;
        prim(graph, V).forEach(System.out::println);
    }

    private static ArrayList<Edge> prim(Graph graph, int V) {
        boolean[] selected = new boolean[V];
        Edge[] nodeEdge = new Edge[V];
        int curr = 0;
        for (int i = 0; i < V; i++) {
            int next = curr;
            selected[curr] = true;
            Map<Integer, Integer> adjacent = graph.getEdges(curr);
            for (int neighbor : adjacent.keySet()) {
                if (nodeEdge[neighbor] == null || nodeEdge[neighbor].weight > adjacent.get(neighbor)) {
                    if (selected[neighbor]) continue;
                    nodeEdge[neighbor] = new Edge(curr, neighbor, adjacent.get(neighbor));
                    next = neighbor;
                }
            }
            curr = next;
        }
        ArrayList<Edge> result = new ArrayList<>();
        for (Edge edge : nodeEdge) {
            if (edge != null) result.add(edge);
        }
        return result;
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

    private static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", weight=" + weight +
                    '}';
        }
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

        Map<Integer, Integer> getEdges(int node) {
            return adj.get(node);
        }
    }
}
