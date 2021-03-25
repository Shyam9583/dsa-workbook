package graph;

public class CalculateNumberOfSpanningTrees {
    public static void main(String[] args) {
        boolean[][] graph = {
                {false, false, true, true},
                {false, false, true, true},
                {true, true, false, true},
                {true, true, true, false}
        };
        int V = 4;
        System.out.println(numSpanningTrees(graph, V));
    }

    private static int numSpanningTrees(boolean[][] graph, int V) {
        int[][] matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            int cnt = 0;
            for (int j = 0; j < V; j++) {
                if (i == j) continue;
                if (graph[i][j]) {
                    cnt++;
                    matrix[i][j] = -1;
                }
            }
            matrix[i][i] = cnt;
        }
        return cofactor(matrix, V);
    }

    private static int cofactor(int[][] matrix, int N) {
        int[][] subMatrix = new int[N - 1][N - 1];
        for (int i = 1; i < N; i++) {
            System.arraycopy(matrix[i], 1, subMatrix[i - 1], 0, N - 1);
        }
        return determinant(subMatrix, N - 1);
    }

    private static int determinant(int[][] matrix, int N) {
        if (N == 1) return matrix[0][0];
        if (N == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int result = 0;
        for (int col = 0; col < N; col++) {
            int[][] temp = new int[N - 1][N - 1];
            for (int i = 1; i < N; i++) {
                for (int j = 0, ptr = 0; j < N; j++) {
                    if (j == col) continue;
                    temp[i - 1][ptr++] = matrix[i][j];
                }
            }
            result += ((col & 1) == 1 ? -1 : 1) * matrix[0][col] * determinant(temp, N - 1);
        }
        return result;
    }
}
