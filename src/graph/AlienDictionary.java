package graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict, N, K));
    }

    private static String findOrder(String[] dict, int N, int K) {
        Graph graph = new Graph();
        Map<Character, Integer> inDegree = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            addEdges(graph, dict[i], dict[i + 1]);
        }
        for (char c : graph.getNodes()) {
            inDegree.putIfAbsent(c, 0);
            for (char neighbor : graph.getNeighbors(c)) {
                inDegree.putIfAbsent(neighbor, 0);
                inDegree.replace(neighbor, inDegree.get(neighbor) + 1);
            }
        }
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            char curr = queue.remove();
            for (char neighbor : graph.getNeighbors(curr)) {
                int degree = inDegree.get(neighbor) - 1;
                if (degree == 0) {
                    queue.add(neighbor);
                }
                inDegree.replace(neighbor, degree);
            }
            builder.append(curr);
        }
        return builder.toString();
    }

    private static void addEdges(Graph graph, String A, String B) {
        int len = Math.min(A.length(), B.length());
        int pos = 0;
        while (pos < len && A.charAt(pos) == B.charAt(pos)) pos++;
        if (pos == len) return;
        graph.addEdge(A.charAt(pos), B.charAt(pos));
    }

    private static class Graph {
        private final Map<Character, Set<Character>> adj;

        Graph() {
            adj = new HashMap<>();
        }

        void addEdge(char u, char v) {
            adj.putIfAbsent(u, new HashSet<>());
            adj.putIfAbsent(v, new HashSet<>());
            adj.get(u).add(v);
        }

        Set<Character> getNodes() {
            return adj.keySet();
        }

        Set<Character> getNeighbors(char node) {
            return adj.get(node);
        }
    }
}
