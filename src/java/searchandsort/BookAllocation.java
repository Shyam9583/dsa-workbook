package java.searchandsort;

import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int m = 2;
        System.out.println(findPages(pages, pages.length, m));
    }

    private static int findPages(int[] pages, int n, int m) {
        int minPages = Integer.MAX_VALUE;
        Arrays.sort(pages);
        int low = pages[n - 1], high = Arrays.stream(pages).sum();
        while (low < high) {
            int cnt = 1, sum = 0;
            int mid = low + (high - low) / 2;
            for (int p : pages) {
                if (sum + p > mid) {
                    cnt++;
                    sum = p;
                } else {
                    sum += p;
                }
            }
            if (cnt > m) {
                low = mid + 1;
            } else {
                if (mid < minPages)
                    minPages = mid;
                high = mid - 1;
            }
        }
        return minPages;
    }
}
