package java.searchandsort;

public class SticklerThief {
    public static void main(String[] args) {
        int[] houses = {5, 5, 10, 100, 10, 5};
        System.out.println(maximumLoot(houses, houses.length));
    }

    private static int maximumLoot(int[] houses, int n) {
        if (n == 2)
            return Math.max(houses[0], houses[1]);

        if (n == 1)
            return houses[0];

        for (int i = 2; i < n; i++) {
            houses[i] = Math.max(houses[i] + houses[i - 2], houses[i - 1]);
        }

        return houses[houses.length - 1];
    }
}
