package searchandsort;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSums {
    public static void main(String[] args) {
        long[] arr = {1, -2, 3};
        int l = -1, u = 2;
        System.out.println(count(arr, arr.length, l, u));
    }

    private static int count(long[] arr, int N, long lower, long upper) {
        int count = 0;
        ArrayList<Long> subsetSumA = new ArrayList<>();
        ArrayList<Long> subsetSumB = new ArrayList<>();
        createSubsets(arr, N, subsetSumA, subsetSumB);
        subsetSumB.sort(Long::compare);
        long[] space = new long[subsetSumB.size()];
        {
            int ptr = 0;
            for (long el : subsetSumB) space[ptr++] = el;
        }
        for (long x : subsetSumA) {
            int l = lowerBound(space, lower - x);
            int u = upperBound(space, upper - x);
            count += u - l;
        }
        return count;
    }

    private static void createSubsets(long[] arr, int N, ArrayList<Long> A, ArrayList<Long> B) {
        long[] left = Arrays.copyOfRange(arr, 0, N / 2 + 1);
        long[] right = Arrays.copyOfRange(arr, N / 2 + 1, N);
        sequence(left, left.length, -1, A, 0);
        sequence(right, right.length, -1, B, 0);
    }

    private static void sequence(long[] arr, int n, int index, ArrayList<Long> subsetSums, long curr) {
        if (index == n)
            return;
        subsetSums.add(curr);
        for (int i = index + 1; i < n; i++) {
            curr += arr[i];
            sequence(arr, n, i, subsetSums, curr);
            curr -= arr[i];
        }
    }

    private static int lowerBound(long[] arr, long key) {
        int low = -1, high = arr.length;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private static int upperBound(long[] arr, long key) {
        int low = -1, high = arr.length;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low + 1;
    }
}
