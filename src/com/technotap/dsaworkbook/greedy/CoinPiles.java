package com.technotap.dsaworkbook.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinPiles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] NK, P;
        for (int t = 0; t < T; t++) {
            NK = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            P = Arrays.stream(reader.readLine().trim().split(" ")).limit(NK[0]).mapToInt(Integer::parseInt).toArray();
            System.out.println(removalRequired(P, NK[0], NK[1]));
        }
    }

    private static int removalRequired(int[] piles, int n, int k) {
        int minimum = minimum(piles);
        int result = 0;
        for (int pile : piles) {
            int diff = pile - minimum;
            if (diff > k) {
                result += (diff - k);
            }
        }
        return result;
    }

    private static int minimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int item : arr) {
            if (min > item) min = item;
        }
        return min;
    }
}
