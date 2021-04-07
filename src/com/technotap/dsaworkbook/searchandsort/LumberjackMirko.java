package com.technotap.dsaworkbook.searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LumberjackMirko {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
        long[] trees = Arrays.stream(reader.readLine().trim().split(" ")).limit(NM[0]).mapToLong(Long::parseUnsignedLong).toArray();
        System.out.println(height(trees, NM[0], NM[1]));
    }

    private static long height(long[] trees, int n, int m) {
        Arrays.sort(trees);
        long low = 0, high = trees[n - 1];
        long answer = Integer.MIN_VALUE;
        while (low <= high) {
            long collected = 0;
            long mid = low + (high - low) / 2;
            for (long t : trees) {
                collected += Math.max((t - mid), 0);
            }
            if (collected < m) {
                high = mid - 1;
            } else {
                if (answer < mid)
                    answer = mid;
                low = mid + 1;
            }
        }
        return answer;
    }
}
