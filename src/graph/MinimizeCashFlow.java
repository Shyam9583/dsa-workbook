package graph;

public class MinimizeCashFlow {
    public static void main(String[] args) {
        int[][] G = {{0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}};
        minimize(G);
    }

    private static void minimize(int[][] G) {
        int[] amount = new int[G.length];
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G.length; j++) {
                amount[i] += G[j][i] - G[i][j];
            }
        }
        minimizeRec(amount);
    }

    private static void minimizeRec(int[] amount) {
        int maxDebtor = getMin(amount), maxCreditor = getMax(amount);
        if (amount[maxCreditor] == 0 && amount[maxDebtor] == 0) return;
        int min = Math.min(-amount[maxDebtor], amount[maxCreditor]);
        amount[maxCreditor] -= min;
        amount[maxDebtor] += min;
        System.out.println("Person " + maxDebtor + " Gave " + min + " to Person " + maxCreditor + ".");
        minimizeRec(amount);
    }

    private static int getMin(int[] amount) {
        int minIndex = 0, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] < minValue) {
                minIndex = i;
                minValue = amount[i];
            }
        }
        return minIndex;
    }

    private static int getMax(int[] amount) {
        int maxIndex = 0, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] > maxValue) {
                maxIndex = i;
                maxValue = amount[i];
            }
        }
        return maxIndex;
    }
}
