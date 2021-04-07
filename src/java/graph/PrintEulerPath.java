package java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrintEulerPath {
    public static void main(String[] args) {
        int V = 5, E = 5;
        int[][] edges = {{5, 1}, {1, 2}, {2, 4}, {3, 4}, {2, 3}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int v = 0; v <= V; v++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        printPath(V, E, adj);
    }

    private static void printPath(int V, int E, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> result = new Stack<>();
        int nOdds = 0, start = 0;
        for (int v = 1; v <= V; v++) {
            if ((adj.get(v).size() & 1) == 1) {
                ++nOdds;
                start = v;
            }
            if (nOdds > 2) {
                System.out.println("NO SOLUTION EXISTS!");
                return;
            }
        }
        Map<Integer, Integer> visited = new HashMap<>();
        dfs(start, visited, result, adj);
        if (result.size() == E + 1) {
            while (!result.isEmpty()) System.out.print(result.pop() + " ");
        } else {
            System.out.println("NO SOLUTION EXISTS!");
        }
    }

    private static void dfs(int curr, Map<Integer, Integer> visited, Stack<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        for (int next : adj.get(curr)) {
            if (isTaken(visited, curr, next)) continue;
            visited.put(curr, next);
            dfs(next, visited, result, adj);
        }
        result.push(curr);
    }

    private static boolean isTaken(Map<Integer, Integer> visited, int u, int v) {
        return (visited.containsKey(u) && visited.get(u) == v) || (visited.containsKey(v) && visited.get(v) == u);
    }
}
