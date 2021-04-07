package java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToCompleteDAG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 10;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {
                {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 8}, {2, 9},
                {3, 6}, {4, 6}, {4, 8}, {5, 8}, {6, 7}, {7, 8},
                {8, 10}
        };
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        System.out.println(Arrays.toString(completionTime(V, adj)));
    }

    private static int[] completionTime(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V + 1];
        int[] completionTime = new int[V];
        int time = 0;
        for (int i = 1; i <= V; i++) {
            for (int node : adj.get(i)) inDegree[node]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while (size-- > 0) {
                int curr = queue.remove();
                completionTime[curr - 1] = time;
                for (int neighbor : adj.get(curr)) {
                    if (--inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return completionTime;
    }

}
