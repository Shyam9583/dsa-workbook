package backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationOfSequence {
    public static void main(String[] args) {
        int n = 3, k = 5;
        System.out.println(kthPermutation(n, k));
    }

    private static String kthPermutation(int n, int k) {
        int[] factorial = factorial(n);
        List<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int index;
        for (int i = 1; i <= n; i++) list.add(i);
        while (n-- > 0) {
            index = k / factorial[n];
            if (k % factorial[n] == 0) index--;
            builder.append(list.remove(index));
            k -= index * factorial[n];
        }
        return builder.toString();
    }

    private static int[] factorial(int n) {
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }
}
