package com.technotap.dsaworkbook.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CheckIfGraphIsATree {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        System.out.println(graph.isATree());
    }

    private static class Graph {
        int nVertices;
        ArrayList<LinkedList<Integer>> adj;

        Graph(int _nVertices) {
            nVertices = _nVertices;
            adj = new ArrayList<>();
            for (int i = 0; i < nVertices; i++)
                adj.add(new LinkedList<>());
        }

        void addEdge(int from, int to) {
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean isATree() {
            boolean[] visited = new boolean[nVertices];
            if (isCyclic(0, visited, -1))
                return false;
            for (int u = 0; u < nVertices; u++) {
                if (!visited[u])
                    return false;
            }
            return true;
        }

        boolean isCyclic(int v, boolean[] visited, int parent) {
            visited[v] = true;
            Iterator<Integer> it = adj.get(v).iterator();
            Integer i;
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i]) {
                    if (isCyclic(i, visited, v))
                        return true;
                } else if (i != parent)
                    return true;
            }
            return false;
        }
    }
}
