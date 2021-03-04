package backtracking;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 11, 10, 5};
        System.out.println(partitionDP(arr, arr.length));
    }

    private static int partitionRecursive(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        if ((sum & 1) == 1) return 0;
        return partitionUtil(arr, 0, 0, sum / 2) ? 1 : 0;
    }

    private static boolean partitionUtil(int[] arr, int i, int currentSum, int halfSum) {
        if (currentSum > halfSum || i >= arr.length) return false;
        if (currentSum == halfSum) return true;
        return partitionUtil(arr, i + 1, currentSum + arr[i], halfSum)
                || partitionUtil(arr, i + 1, currentSum, halfSum);
    }

    private static int partitionDP(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        if ((sum & 1) == 1) return 0;
        boolean[] dp = new boolean[sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= arr[i]; j--) {
                if (dp[j - arr[i]] || j == arr[i])
                    dp[j] = true;
            }
        }
        return dp[sum / 2] ? 1 : 0;
    }
}
