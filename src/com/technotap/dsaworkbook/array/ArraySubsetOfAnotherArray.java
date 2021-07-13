package com.technotap.dsaworkbook.array;

import java.util.HashSet;
import java.util.Set;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] A = {11, 1, 13, 21, 3, 7}, B = {11, 3, 7, 1};
        System.out.println(isSubSet(A, B));
    }

    // Returns true if B is a subset of A
    private static boolean isSubSet(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        for (int item : A) set.add(item);
        for (int item : B) {
            if (set.contains(item)) continue;
            return false;
        }
        return true;
    }
}
