package graph;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class FloydWarshall {

    private static final int INFINITY = 1 << 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(reader.readLine().trim().split(" ")).limit(n).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("\nBefore\n");
        printMatrix(matrix);
        shortestDistance(matrix);
        System.out.println("\nAfter\n");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for(int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void shortestDistance(int[][] matrix) {
        int INF = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][k] < INF && matrix[k][j] < INF
                            && matrix[i][k] + matrix[k][j] < INF
                            && matrix[i][k] != -1
                            && matrix[k][j] != -1
                            && matrix[i][j] != -1)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] >= INF)
                    matrix[i][j] = -1;
            }
        }
    }
}
