package backtracking;

import java.util.Arrays;

public class DivideSetIntoKSubsetsWithEqualSum {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6};
        int k = 3;
        System.out.println(isKPartitionsPossible(arr, arr.length, k));
    }

    private static boolean isKPartitionsPossible(int[] arr, int n, int k) {
        int sum = Arrays.stream(arr).sum();
        return sum % k == 0;
    }
}
