package dynamicprogramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(mcm(arr, arr.length));
    }

    private static int mcm(int[] arr, int n) {
        int[][] dp = new int[n - 1][n - 1];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else if (g > 1) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lr = dp[i][k] + dp[k + 1][j];
                        int m = arr[i] * arr[k + 1] * arr[j + 1];
                        min = Math.min(min, lr + m);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
