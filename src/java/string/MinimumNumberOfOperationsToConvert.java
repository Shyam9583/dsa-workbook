package java.string;

public class MinimumNumberOfOperationsToConvert {
    public static void main(String[] args) {
        String A = "EACBD", B = "EABCD";
        System.out.println(minimumOperations(A, B));
    }

    private static int minimumOperations(String A, String B) {
        int M = A.length(), N = B.length();
        int min = 0;

        if (M != N)
            return -1;

        int[] count = new int[256];

        for (int i = 0; i < M; i++) {
            count[A.charAt(i)]++;
        }
        for (int i = 0; i < N; i++) {
            count[B.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0)
                return -1;
        }

        int i = M - 1, j = M - 1;

        while (i >= 0) {
            while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                i--;
                min++;
            }
            if (i >= 0) {
                i--;
                j--;
            }
        }

        return min;
    }
}
