package searchandsort;

import java.util.Arrays;

public class ComputeProductArray {
    public static void main(String[] args) {
        int[] arr = {12, 0};
        System.out.println(Arrays.toString(compute(arr, arr.length)));
    }

    private static long[] compute(int[] arr, int n) {
        long[] p = new long[n];
        long product = 1;
        int countZeroes = 0;

        // compute product
        for (int el : arr) {
            if (el == 0)
                countZeroes++;
            else
                product *= el;
        }

        // if more than one zero is present
        if (countZeroes > 1)
            return p;

            // if one element is zero
        else if (countZeroes == 1) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    p[i] = product;
                }
            }
            return p;
        }

        // no zeroes - normal case
        else {
            for (int i = 0; i < n; i++) {
                p[i] = product / arr[i];
            }
            return p;
        }
    }
}
