package com.technotap.dsaworkbook.graph;

import java.util.*;

public class ChinesePostmanProblem {

    public static final int INFINITY = 1 << 16;

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0, 1, 3}, {0, 2, 1}, {0, 4, 5}, {1, 3, 1}, {1, 5, 6}, {2, 4, 2}, {3, 5, 1}, {4, 5, 4}};
        ArrayList<Map<Integer, Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new HashMap<>());
        for (int[] e : edges) {
            adj.get(e[0]).put(e[1], e[2]);
            adj.get(e[1]).put(e[0], e[2]);
        }
        System.out.println(solution(V, adj));
    }

    private static int solution(int V, ArrayList<Map<Integer, Integer>> adj) {
        Set<Integer> oddNodes = new HashSet<>();
        int edgeSum = 0;
        for (int v = 0; v < V; v++) {
            if ((adj.get(v).size() & 1) == 1) {
                oddNodes.add(v);
            }
            for (int u : adj.get(v).keySet()) {
                edgeSum += adj.get(v).get(u);
            }
        }
        edgeSum /= 2;
        if (oddNodes.isEmpty()) return edgeSum;
        return edgeSum + minSumPair(oddNodes, adj);
    }

    private static int minSumPair(Set<Integer> oddNodes, ArrayList<Map<Integer, Integer>> adj) {
        int n = adj.size();
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i).keySet()) {
                distance[i][j] = adj.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (distance[i][j] == 0) {
                    distance[i][j] = distance[j][i] = INFINITY;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j || !oddNodes.contains(i) || !oddNodes.contains(j)) continue;
                heap.add(new Pair(i, j, distance[i][j]));
            }
        }
        boolean[] selected = new boolean[n];
        int sum = 0;
        for (int i = 0; i < 2 && !heap.isEmpty(); ) {
            Pair pair = heap.remove();
            if (selected[pair.u] || selected[pair.v]) continue;
            sum += pair.weight;
            selected[pair.u] = selected[pair.v] = true;
            i++;
        }
        return sum;
    }

    private static class Pair implements Comparable<Pair> {
        int u, v, weight;

        Pair(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair pair) {
            if (weight == pair.weight) return u - pair.u;
            return weight - pair.weight;
        }
    }
}
