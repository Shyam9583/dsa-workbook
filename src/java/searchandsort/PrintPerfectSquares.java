package java.searchandsort;

public class PrintPerfectSquares {
    public static void main(String[] args) {
        int N = 18;
        System.out.println(print(N));
    }

    private static int print(int N) {
        int limit = (int) Math.sqrt(N);
        int count = 0;
        for (int i = 1; i <= limit; i++) {
            if (i * i < N)
                count++;
        }
        return count;
    }
}
