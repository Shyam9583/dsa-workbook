package java.searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class RastaAndKheshtaks {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, m, x, y;
        int[][] A, B;
        int[] sizesA = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
        n = sizesA[0];
        m = sizesA[1];
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            A[i] = Arrays.stream(reader.readLine().trim().split(" ")).limit(m).mapToInt(Integer::parseInt).toArray();
        }
        int[] sizesB = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
        x = sizesB[0];
        y = sizesB[1];
        B = new int[x][y];
        for (int i = 0; i < x; i++) {
            B[i] = Arrays.stream(reader.readLine().trim().split(" ")).limit(y).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bcs(A, B, n, m, x, y));
    }

    private static int bcs(int[][] A, int[][] B, int n, int m, int x, int y) {
        HashMap<Long, Square> map = new HashMap<>();

        int min = Math.min(n, Math.min(m, Math.min(x, y)));
        for (int size = min; size > 0; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    long hash = hash(A, i, j, size);
                    map.put(hash, new Square(i, j));
                }
            }
        }
        for (int size = min; size > 0; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    long hash = hash(B, i, j, size);
                    if (map.containsKey(hash)) {
                        Square entry = map.get(hash);
                        if (bothSquaresSame(A, B, entry.row, entry.col, i, j, size)) {
                            return size;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static long hash(int[][] square, int startRow, int startColumn, int size) {
        long base = 101;
        long range = Long.MAX_VALUE;
        long hash = 1;
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startColumn; j < startColumn + size; j++) {
                hash += (square[i][j] * base) % range;
                base *= base;
            }
        }
        return hash % range;
    }

    private static boolean bothSquaresSame(int[][] A, int[][] B, int startRowA, int startColumnA, int startRowB, int startColumnB, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (A[startRowA + i][startColumnA + j] != B[startRowB + i][startColumnB + j])
                    return false;
            }
        }
        return true;
    }

    private static class Square {
        int row, col;

        Square(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
