package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTaskCompletionIsPossible {
    public static void main(String[] args) {
        int T = 2;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {
                {1, 0}, {0, 1}
        };
        for (int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(completionStatus(T, adj));
    }

    private static boolean completionStatus(int T, ArrayList<ArrayList<Integer>> requisite) {
        int cnt = 0;
        int[] inDegree = new int[T];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            for (int node : requisite.get(i)) inDegree[node]++;
        }
        for (int i = 0; i < T; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.remove();
                for (int neighbor : requisite.get(curr)) {
                    if (--inDegree[neighbor] == 0) queue.add(neighbor);
                }
                cnt++;
            }
        }
        return cnt == T;
    }
}
