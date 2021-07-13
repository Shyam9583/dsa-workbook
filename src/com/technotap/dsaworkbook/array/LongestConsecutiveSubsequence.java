package com.technotap.dsaworkbook.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(findLongestConseqSubseq(arr, arr.length));
    }

    private static int findLongestConseqSubseq(int[] arr, int N) {
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int item : arr) set.add(item);
        for (int item : arr) {
            if (set.contains(item - 1)) continue;
            int next = item + 1;
            while (set.contains(next)) {
                next++;
            }
            longest = Math.max(longest, next - item);
        }
        return longest;
    }
}
