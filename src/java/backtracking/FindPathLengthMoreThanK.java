package java.backtracking;

public class FindPathLengthMoreThanK {
    public static void main(String[] args) {
        int[][] adj = init();
        int k = 62;
        System.out.println(pathExists(adj, adj.length, k));
    }

    private static boolean pathExists(int[][] adj, int n, int k) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        return pathExistsUtil(adj, n, 0, visited, 0, k);
    }

    private static boolean pathExistsUtil(int[][] adj, int n, int s, boolean[] visited, int sum, int k) {
        if (sum > k) return true;
        for (int i = 0; i < n; i++) {
            if (adj[s][i] != 0 && !visited[i]) {
                visited[i] = true;
                if (pathExistsUtil(adj, n, i, visited, sum + adj[s][i], k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    private static int[][] init() {
        int N = 9;
        int[][] adj = new int[N][N];
        insertEdge(adj, 0, 1, 4);
        insertEdge(adj, 0, 7, 8);
        insertEdge(adj, 1, 7, 11);
        insertEdge(adj, 1, 2, 8);
        insertEdge(adj, 2, 8, 2);
        insertEdge(adj, 2, 5, 4);
        insertEdge(adj, 2, 3, 7);
        insertEdge(adj, 3, 5, 14);
        insertEdge(adj, 3, 4, 9);
        insertEdge(adj, 4, 5, 10);
        insertEdge(adj, 5, 6, 2);
        insertEdge(adj, 6, 7, 1);
        insertEdge(adj, 6, 8, 6);
        insertEdge(adj, 7, 8, 7);
        return adj;
    }

    private static void insertEdge(int[][] adj, int from, int to, int weight) {
        adj[from][to] = weight;
        adj[to][from] = weight;
    }

}
