package com.technotap.dsaworkbook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ArrangingAmplifiers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()), N;
        Integer[] arr;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(reader.readLine());
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(N).map(Integer::valueOf).toArray(Integer[]::new);
            System.out.print(printArrangement(arr, N));
        }
    }

    private static String printArrangement(Integer[] amplifiers, int n) {
        if (n == 1) return String.valueOf(amplifiers[0]);

        StringBuilder builder = new StringBuilder();

        int nOnes = (int) Arrays.stream(amplifiers).filter(item -> item == 1).count();
        IntStream.range(0, nOnes).forEach(i -> builder.append(1 + " "));

        if (n - nOnes > 2) {
            Arrays.sort(amplifiers, Collections.reverseOrder());
            IntStream.range(0, n - nOnes).forEach(i -> builder.append(amplifiers[i]).append(" "));
        } else {
            Arrays.sort(amplifiers);
            builder.append(amplifiers[nOnes]).append(" ").append(amplifiers[nOnes + 1]);
        }

        return builder.toString();
    }

}
