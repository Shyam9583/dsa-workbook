package com.technotap.dsaworkbook.greedy;

public class BuyMaximumStockForIthDay {

    public static void main(String[] args) {
        int[] dayPrice = {7, 10, 4};
        int k = 45;
        System.out.println(maxStocks(dayPrice, dayPrice.length, k));
    }

    private static int maxStocks(int[] dayPrice, int n, int k) {
        int bought = 0;
        for (int i = 0; i < n; i++) {
            int quantity = Math.min(i + 1, k / dayPrice[i]);
            bought += quantity;
            k -= quantity * dayPrice[i];
        }
        return bought;
    }
}
