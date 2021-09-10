package com.technotap.dsaworkbook.greedy;

import java.util.ArrayList;

public class KCentersProblem {
    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] weights = {
                {0, 4, 8, 5},
                {4, 0, 10, 7},
                {8, 10, 0, 9},
                {5, 7, 9, 0}};
        System.out.println(pickCenters(n, weights, k));
    }

    private static ArrayList<Integer> pickCenters(int n, int[][] weights, int k) {
        ArrayList<Integer> centers = new ArrayList<>();
        centers.add(0);
        while (--k > 0) {
            int selected = 0, max = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                if (centers.contains(i)) continue;
                int dist = Integer.MAX_VALUE;
                for (int center : centers) dist = Math.min(dist, weights[center][i]);
                if (max < dist) {
                    selected = i;
                    max = dist;
                }
            }
            centers.add(selected);
        }
        return centers;
    }
}
