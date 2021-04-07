package java.greedy;

import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};
        System.out.println(minimumPlatformsMapMethod(arr, dep, arr.length));
    }

    // for when there are too much space required
    private static int minimumPlatformsBinarySearch(int[] arr, int[] dep, int n) {
        int best = n;
        int low = 1, high = n;
        while (low < high) {
            int mid = (high - low) / 2;
            int[] platforms = new int[mid];
            int platformed = 0;
            for (int i = 0; i < n; i++) {
                int j = 0;
                while (j < mid) {
                    if (platforms[j] <= arr[i]) break;
                    j++;
                }
                if (j < mid) {
                    platforms[j] = dep[i];
                    platformed++;
                }
            }
            if (platformed < n) {
                low = mid;
            } else {
                if (best > mid)
                    best = mid;
                high = mid;
            }
        }
        return best;
    }

    private static int minimumPlatformsMapMethod(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1, j = 0, result = 1, needed = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                needed++;
                i++;
            } else {
                needed--;
                j++;
            }
            if (result < needed) result = needed;
        }
        return result;
    }

}
