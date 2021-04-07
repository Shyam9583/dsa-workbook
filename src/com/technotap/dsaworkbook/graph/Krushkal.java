package com.technotap.dsaworkbook.graph;

import java.util.*;

public class Krushkal {
    public static void main(String[] args) {
        Graph graph = getGraph();
        ArrayList<Edge> edges = graph.getEdges();
        int V = graph.getNodeCount(edges);
        krushkal(edges, V).forEach(System.out::println);
    }

    private static ArrayList<Edge> krushkal(ArrayList<Edge> edges, int V) {
        ArrayList<Edge> result = new ArrayList<>();
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        edges.sort(Comparator.comparingInt(o -> o.weight));
        for (Edge edge : edges) {
            int parentU = find(edge.u, parent);
            int parentV = find(edge.v, parent);
            if (parentU != parentV) {
                union(edge.u, edge.v, parent);
                result.add(edge);
            }
        }
        return result;
    }

    private static int find(int node, int[] parent) {
        int root = node;
        while (parent[root] >= 0) root = parent[root];
        while (node != root) {
            int temp = parent[node];
            parent[node] = root;
            node = temp;
        }
        return root;
    }

    private static void union(int x, int y, int[] parent) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        if (parent[parentX] < parent[parentY]) {
            parent[parentX] += parent[parentY];
            parent[parentY] = parentX;
        } else {
            parent[parentY] += parent[parentX];
            parent[parentX] = parentY;
        }
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
        }

        int getNodeCount(ArrayList<Edge> edges) {
            Set<Integer> set = new HashSet<>();
            for (Edge e : edges) {
                set.add(e.u);
                set.add(e.v);
            }
            return set.size();
        }

        ArrayList<Edge> getEdges() {
            ArrayList<Edge> edges = new ArrayList<>();
            for (int u : adj.keySet()) {
                for (int v : adj.get(u).keySet()) {
                    edges.add(new Edge(u, v, adj.get(u).get(v)));
                }
            }
            return edges;
        }
    }
}
