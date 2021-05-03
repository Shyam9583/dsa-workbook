package com.technotap.dsaworkbook.bitmanipulation;

public class FindTriplet {
    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 3, 3, 5, 3, 2, 5, 3, 8, 9};
        System.out.println(countTriplets(arr));
    }

    private static int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                xor ^= arr[k];
                if (xor == 0) count += (k - i);
            }
        }
        return count;
    }
}
