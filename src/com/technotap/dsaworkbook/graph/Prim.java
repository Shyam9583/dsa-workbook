package com.technotap.dsaworkbook.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prim {
    public static void main(String[] args) {
        Graph graph = getGraph();
        int V = 9;
        System.out.println(prim(graph, V).stream().mapToInt(o -> o.weight).sum());
    }

    private static ArrayList<Edge> prim(Graph graph, int V) {
        int[] distance = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        int curr = 0;
        for (int i = 1; i < V; i++) {
            visited[curr] = true;
            Map<Integer, Integer> edges = graph.getEdges(curr);
            for (int neighbor : edges.keySet()) {
                if (edges.get(neighbor) < distance[neighbor]) {
                    distance[neighbor] = edges.get(neighbor);
                    parent[neighbor] = curr;
                }
            }
            curr = min(distance, visited);
        }
        ArrayList<Edge> result = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            result.add(new Edge(parent[i], i, distance[i]));
        }
        return result;
    }

    private static int min(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && min > distance[i]) {
                min = distance[i];
                idx = i;
            }
        }
        return idx;
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

        Map<Integer, Integer> getEdges(int node) {
            return adj.get(node);
        }
    }
}
