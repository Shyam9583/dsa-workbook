package com.technotap.dsaworkbook.searchandsort;

public class FindMedianIn2SortedArrays {
    public static void main(String[] args) throws Exception {
        int[] A = {2, 3, 6, 7, 9};
        int[] B = {1, 4, 8, 10};
        System.out.println(median(A, B));
    }

    private static double median(int[] A, int[] B) throws Exception {
        if (A.length > B.length) {
            return median(B, A);
        }

        int x = A.length, y = B.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (low + high + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX - 1];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : A[partitionX];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : B[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new Exception("One or Both Arrays are not sorted properly");
    }
}
