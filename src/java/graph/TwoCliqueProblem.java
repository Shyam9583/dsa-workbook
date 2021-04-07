package java.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TwoCliqueProblem {
    public static void main(String[] args) {
        int[][] G = {{0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0}
        };
        System.out.println(isTwoClique(G));
    }

    private static boolean isTwoClique(int[][] G) {
        int n = G.length;
        int[][] complement = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                complement[i][j] = 1 - G[i][j];
            }
        }
        return isBipartite(complement, n);
    }

    private static boolean isBipartite(int[][] G, int n) {
        int[] color = new int[n];
        Arrays.fill(color, 1, n, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.remove();
            if (G[i][i] == 1) return false;
            for (int j = 0; j < n; j++) {
                if (G[i][j] == 1 && color[i] == color[j]) return false;
                if (G[i][j] == 1 && color[j] == -1) {
                    color[j] = 1 - color[i];
                    q.add(j);
                }
            }
        }
        return true;
    }
}
