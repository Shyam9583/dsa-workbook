package com.technotap.dsaworkbook.graph;

public class TravellingSalesmanProblem {
    public static void main(String[] args) {
        int[][] distance = {
                {0, 10, 15, 20},
                {5, 0, 9, 10},
                {5, 13, 0, 12},
                {8, 8, 9, 0}
        };
        System.out.println(minCost(distance));
    }

    private static int minCost(int[][] distance) {
        return 0;
    }
}
