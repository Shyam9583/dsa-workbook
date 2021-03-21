package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAGraph {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        initGraph(graph);
        System.out.println(graph);
    }

    private static void initGraph(Graph<Character> g) {
        g.addEdge('0', '1', 4);
        g.addEdge('0', '7', 8);
        g.addEdge('1', '7', 11);
        g.addEdge('1', '2', 8);
        g.addEdge('7', '8', 7);
        g.addEdge('2', '8', 2);
        g.addEdge('8', '6', 6);
        g.addEdge('2', '5', 4);
        g.addEdge('6', '5', 2);
        g.addEdge('2', '3', 7);
        g.addEdge('3', '3', 14);
        g.addEdge('3', '4', 9);
        g.addEdge('5', '4', 10);
        g.addEdge('7', '6', 1);
    }

    private static class Edge<T> {
        T node;
        int weight;

        Edge(T node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Graph<T> {
        Map<T, List<Edge<T>>> adj;

        Graph() {
            this.adj = new HashMap<>();
        }

        void addEdge(T from, T to, int weight) {
            adj.putIfAbsent(from, new ArrayList<>());
            adj.putIfAbsent(to, new ArrayList<>());
            adj.get(from).add(new Edge<>(to, weight));
            adj.get(to).add(new Edge<>(from, weight));
        }

        void addEdge(T from, T to) {
            addEdge(from, to, 1);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (T node : adj.keySet()) {
                builder.append(node).append(" : ");
                for (Edge<T> edge : adj.get(node)) {
                    builder.append("(").append(node).append(" -[").append(edge.weight).append("]-> ").append(edge.node).append(" )");
                }
                builder.append('\n');
            }
            return builder.toString();
        }
    }
}
