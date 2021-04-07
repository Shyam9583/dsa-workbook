package java.backtracking;

public class LongestPossibleRouteInTheMatrix {

    private static final int[] moveI = {0, 1, -1, 0};
    private static final int[] moveJ = {1, 0, 0, -1};
    private static int max;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int si = 0, sj = 0, di = 1, dj = 7;
        maxLength(mat, si, sj, di, dj);
    }

    private static void maxLength(int[][] mat, int si, int sj, int di, int dj) {
        max = Integer.MIN_VALUE;
        maxLengthUtil(mat, mat.length, mat[0].length, si, sj, di, dj, 0);
        System.out.println(max != Integer.MIN_VALUE ? max : "Path blocked, unreachable");
    }

    private static void maxLengthUtil(int[][] mat, int n, int m, int i, int j, int di, int dj, int len) {
        if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] == 0) return;
        if (i == di && j == dj) {
            max = Math.max(max, len);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            mat[i][j] = 0;
            maxLengthUtil(mat, n, m, i + moveI[dir], j + moveJ[dir], di, dj, len + 1);
            mat[i][j] = 1;
        }
    }
}
