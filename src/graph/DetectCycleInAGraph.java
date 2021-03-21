package graph;

import java.util.*;
import java.util.stream.Collectors;

public class DetectCycleInAGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}};
        Graph<Integer> graph = createGraph(edges);
        System.out.println(hasCycle(graph));
    }

    private static Graph<Integer> createGraph(int[][] edges) {
        Graph<Integer> graph = new Graph<>();
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }
        return graph;
    }

    private static boolean hasCycle(Graph<Integer> graph) {
        Set<Integer> white = new HashSet<>(graph.adj.keySet());
        Set<Integer> grey = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        while (!white.isEmpty()) {
            int current = white.iterator().next();
            if (hasCycleRec(current, graph, white, grey, black)) return true;
        }
        return false;
    }

    private static boolean hasCycleRec(int current, Graph<Integer> graph, Set<Integer> white, Set<Integer> grey, Set<Integer> black) {
        move(white, grey, current);
        for (int neighbour : graph.getNeighbours(current)) {
            if (black.contains(neighbour)) continue;
            if (grey.contains(neighbour)) return true;
            if (hasCycleRec(neighbour, graph, white, grey, black)) return true;
        }
        move(grey, black, current);
        return false;
    }

    private static void move(Set<Integer> A, Set<Integer> B, Integer x) {
        A.remove(x);
        B.add(x);
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
        private final Map<T, List<Edge<T>>> adj;

        Graph() {
            this.adj = new HashMap<>();
        }

        int size() {
            return adj.size();
        }

        void addEdge(T from, T to, int weight) {
            adj.putIfAbsent(from, new ArrayList<>());
            adj.putIfAbsent(to, new ArrayList<>());
            adj.get(from).add(new Edge<>(to, weight));
        }

        void addEdge(T from, T to) {
            addEdge(from, to, 1);
        }

        List<Edge<T>> getEdges(T node) {
            return adj.get(node);
        }

        List<T> getNeighbours(T node) {
            return adj.get(node).stream().map(o -> o.node).collect(Collectors.toCollection(ArrayList::new));
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
