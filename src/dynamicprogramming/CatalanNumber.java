package dynamicprogramming;

public class CatalanNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalan(n));
    }

    private static long catalan(int n) {
        long[] c = new long[n + 1];
        c[0] = c[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                c[i] += c[j] * c[i - j - 1];
            }
        }
        return c[n];
    }
}
