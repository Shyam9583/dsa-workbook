package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    private static final int INFINITY = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgement", "shall", "be"};
        int maxWidth = 15;
        System.out.println(fullJustify(words, maxWidth));
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        int[][] spaces = new int[N][N];
        int[] preSum = new int[N + 1], cost = new int[N + 1], next = new int[N + 1], optimalSpaces = new int[N];
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + words[i - 1].length();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i, gap = 0; j < N; j++, gap++) {
                spaces[i][j] = maxWidth - (preSum[j + 1] - preSum[i] + gap);
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            int minCost = INFINITY;
            for (int j = N; j > i; j--) {
                int penalty = spaces[i][j - 1] < 0 ? INFINITY : spaces[i][j - 1] * spaces[i][j - 1];
                int currCost = cost[j] + penalty;
                if (currCost < minCost) {
                    next[i] = j;
                    optimalSpaces[i] = spaces[i][j - 1];
                    minCost = currCost;
                }
            }
            cost[i] = minCost;
        }
        // append spaces based on count
        for (int curr = 0; curr != N; curr = next[curr]) {
            StringBuilder builder = new StringBuilder(words[curr]);
            int count = next[curr] - curr;
            if (count < 3 || next[curr] == N) {
                for (int i = curr + 1; i < next[curr]; i++) {
                    builder.append(" ").append(words[i]);
                }
                while (optimalSpaces[curr]-- > 0) builder.append(" ");
            } else {
                // distribute remaining spaces
                int spacing = (optimalSpaces[curr] / (count - 1)) + 1;
                int remaining = optimalSpaces[curr] % (count - 1);
                for (int i = curr + 1; i < next[curr]; i++) {
                    for (int c = 0; c < spacing; c++) builder.append(" ");
                    if (remaining-- > 0) builder.append(" ");
                    builder.append(words[i]);
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}
