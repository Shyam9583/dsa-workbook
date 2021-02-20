package greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        System.out.println(fractionalKnapsack(W, items, items.length));
    }

    private static double fractionalKnapsack(int W, Item[] items, int n) {
        Arrays.sort(items, (o2, o1) -> Double.compare((o1.value * 1.0) / o1.weight, (o2.value * 1.0) / o2.weight));
        double maxValue = 0;
        int i = 0;
        while (W > 0 && i < n) {
            if (W - items[i].weight >= 0) {
                maxValue += items[i].value;
                W -= items[i].weight;
            } else {
                maxValue += ((items[i].value * 1.0) * W) / items[i].weight;
                W = 0;
            }
            i++;
        }
        return maxValue;
    }

    private static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
