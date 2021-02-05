package searchandsort;

public class CheckIfExistsInAP {
    public static void main(String[] args) {
        int A = 0, B = 1, C = 0;
        System.out.println(exists(A, B, C));
    }

    private static boolean exists(int A, int B, int C) {
        if (C == 0)
            return A == B;
        double n = (B - A) / ((double) C);
        return (n % 1 == 0) && n >= 0;
    }
}
