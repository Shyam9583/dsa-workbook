package dynamicprogramming;

public class BinomialCoefficient {

    private static final int M = (int) (10e9 + 7);

    public static void main(String[] args) {
        int n = 5, r = 3;
        System.out.println(nCr(n, r));
    }

    private static int nCr(int n, int r) {
        int last = 1;
        for (int i = 1; i < r; i++) {
            last = ((last * (n - i + 1)) % M) / i;
        }
        return last;
    }
}
