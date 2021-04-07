package com.technotap.dsaworkbook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateBreaking {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int C;
        int[] NM;
        Integer[] X, Y;
        try {
            C = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            C = 0;
        }
        reader.readLine();
        for (int c = 0; c < C; c++) {
            NM = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            X = new Integer[NM[0] - 1];
            Y = new Integer[NM[1] - 1];
            for (int i = 0; i < X.length; i++) X[i] = Integer.parseInt(reader.readLine());
            for (int i = 0; i < Y.length; i++) Y[i] = Integer.parseInt(reader.readLine());
            System.out.println(minCost(X, Y, X.length, Y.length));
        }
    }

    private static int minCost(Integer[] X, Integer[] Y, int n, int m) {
        Arrays.sort(X, Collections.reverseOrder());
        Arrays.sort(Y, Collections.reverseOrder());
        int totalCost = 0, i = 0, j = 0, xCost = 1, yCost = 1;
        while (i < n && j < m) {
            if (X[i] > Y[j]) {
                totalCost += X[i] * yCost;
                xCost++;
                i++;
            } else {
                totalCost += Y[j] * xCost;
                yCost++;
                j++;
            }
        }
        int sum = 0;
        while (i < n) sum += X[i++];
        totalCost += sum * yCost;
        sum = 0;
        while (j < m) sum += Y[j++];
        totalCost += sum * xCost;
        return totalCost;
    }

}
