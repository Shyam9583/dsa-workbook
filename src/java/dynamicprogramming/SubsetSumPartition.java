package java.dynamicprogramming;

import java.util.Arrays;

public class SubsetSumPartition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        System.out.println(equalPartition(arr.length, arr));
    }

    private static int equalPartition(int N, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if ((sum & 1) == 1) return 0;
        sum /= 2;
        boolean[] curr = new boolean[sum + 1], prev = new boolean[sum + 1], temp;
        curr[0] = prev[0] = true;
        for (int i = 0; i < N; i++) {
            temp = curr;
            curr = prev;
            prev = temp;
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i]) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j] || prev[j - arr[i]];
                }
            }
        }
        return curr[curr.length - 1] ? 1 : 0;
    }
}
