package backtracking;

public class MColoring {

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] edges = {
                {1, 2},
                {2, 3},
                {1, 3}
        };
        System.out.println(mColoring(n, m, edges));
    }

    private static boolean mColoring(int n, int m, int[][] edges) {
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] colors = new int[n + 1];
        for (int[] edge : edges)
            adj[edge[0]][edge[1]] = adj[edge[1]][edge[0]] = true;
        return mColoringUtil(adj, n, colors, 1, m, 0);
    }

    private static boolean mColoringUtil(boolean[][] adj, int n, int[] colors, int source, int m, int nColored) {
        if (nColored == n) return true;
        if (colors[source] != 0) return false;
        for (int color = 1; color <= m; color++) {
            if (!isTaken(source, color, adj, colors)) {
                colors[source] = color;
                for (int i = 1; i <= n; i++) {
                    if (adj[source][i]) {
                        if (mColoringUtil(adj, n, colors, i, m, nColored + 1))
                            return true;
                    }
                }
                colors[source] = 0;
            }
        }
        return false;
    }

    private static boolean isTaken(int vertex, int color, boolean[][] adj, int[] colors) {
        for (int i = 1; i < adj[vertex].length; i++) {
            if (adj[vertex][i] && colors[i] == color) return true;
        }
        return false;
    }

}
