package graph;

public class CountTriangles {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
        int[][] digraph = {{0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(count(graph.length, graph, false));
        System.out.println(count(digraph.length, digraph, true));
    }

    private static int count(int V, int[][] graph, boolean directed) {
        int count = 0;
        if (V < 3) return count;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if ((graph[i][j] == 1) && (graph[j][k] == 1) && (graph[k][i] == 1)) {
                        count++;
                    }
                }
            }
        }
        return directed ? count / 3 : count / 6;
    }

}
