package com.technotap.dsaworkbook.bitmanipulation;

public class FindNumberOccurringOnceInThriceRepeating {
    public static void main(String[] args) {
        int[] arr = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int val : arr) {
                if ((val & mask) != 0) ++count;
            }
            if ((count % 3) != 0) result |= mask;
        }
        return result;
    }
}
