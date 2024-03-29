package com.technotap.dsaworkbook.greedy;

public class MinimizeCashFlow {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}
        };
        minimizeCashFlow(graph);
    }

    private static void minimizeCashFlow(int[][] graph) {
        int[] amount = new int[graph.length];
        for (int p = 0; p < graph.length; p++) {
            for (int i = 0; i < graph.length; i++) {
                amount[p] += graph[i][p] - graph[p][i];
            }
        }
        while (true) {
            int maxDebtor = maxDebtor(amount), maxCreditor = maxCreditor(amount);
            if (amount[maxDebtor] == 0 && amount[maxCreditor] == 0) break;
            int minAmount = Math.min(-amount[maxDebtor], amount[maxCreditor]);
            amount[maxDebtor] += minAmount;
            amount[maxCreditor] -= minAmount;
            System.out.println(maxDebtor + " gave " + maxCreditor + " $" + minAmount);
        }
    }

    private static int maxDebtor(int[] amount) {
        int result = 0;
        for (int i = 1; i < amount.length; i++)
            if (amount[result] > amount[i]) result = i;
        return result;
    }

    private static int maxCreditor(int[] amount) {
        int result = 0;
        for (int i = 1; i < amount.length; i++)
            if (amount[result] < amount[i]) result = i;
        return result;
    }

}
