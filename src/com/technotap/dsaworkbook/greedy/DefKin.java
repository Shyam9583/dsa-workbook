package com.technotap.dsaworkbook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DefKin {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        int[] WHN, TH, TW;
        for (int t = 0; t < T; t++) {
            WHN = Arrays.stream(reader.readLine().trim().split(" ")).limit(3).mapToInt(Integer::parseInt).toArray();
            TH = new int[WHN[2]];
            TW = new int[WHN[2]];
            for (int i = 0; i < WHN[2]; i++) {
                int[] temp = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
                TW[i] = temp[0];
                TH[i] = temp[1];
            }
            System.out.println(penalty(WHN[0], WHN[1], TW, TH));
        }
    }

    private static int penalty(int w, int h, int[] tw, int[] th) {
        Arrays.sort(tw);
        Arrays.sort(th);
        return maxDifference(w, tw) * maxDifference(h, th);
    }

    private static int maxDifference(int limit, int[] items) {
        int max = items[0];
        for (int i = 1; i < items.length; i++) {
            max = Math.max(max, items[i] - items[i - 1]);
        }
        return Math.max(max, limit + 1 - items[items.length - 1]) - 1;
    }

}
