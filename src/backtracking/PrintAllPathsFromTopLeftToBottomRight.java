package backtracking;

public class PrintAllPathsFromTopLeftToBottomRight {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6}
        };
        print(mat);
    }

    private static void print(int[][] mat) {
        printUtil(mat, mat.length, mat[0].length, 0, 0, "");
    }

    private static void printUtil(int[][] mat, int n, int m, int i, int j, String result) {
        if (i >= n || j >= m || mat[i][j] == 0) return;
        if (i == n - 1 && j == m - 1) {
            System.out.println(result + mat[i][j]);
        } else {
            int value = mat[i][j];
            String curr = result + value + " ";
            mat[i][j] = 0;
            printUtil(mat, n, m, i + 1, j, curr);
            printUtil(mat, n, m, i, j + 1, curr);
            mat[i][j] = value;
        }
    }
}
