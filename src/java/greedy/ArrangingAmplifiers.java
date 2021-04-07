package java.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrangingAmplifiers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()), N;
        int[] arr;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(reader.readLine());
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(N).mapToInt(Integer::parseInt).toArray();
            printArrangement(arr, N);
        }
    }

    private static void printArrangement(int[] amplifiers, int n) {
        if (n == 1) {
            System.out.println(amplifiers[0]);
            return;
        }
        int nOnes = 0;
        for (int a : amplifiers) {
            if (a == 1) nOnes++;
        }
        n -= nOnes;
        if (n > 2) {
            sort(amplifiers, 0, amplifiers.length - 1, true);
            for (int i = 0; i < nOnes; i++)
                System.out.print(1 + " ");
            for (int i = 0; i < n; i++)
                System.out.print(amplifiers[i] + " ");
        } else {
            sort(amplifiers, 0, amplifiers.length - 1, false);
            for (int amplifier : amplifiers) System.out.print(amplifier + " ");
        }
        System.out.println();
    }

    private static void sort(int[] arr, int low, int high, boolean reverse) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid, reverse);
            sort(arr, mid + 1, high, reverse);
            merge(arr, low, mid, high, reverse);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, boolean reverse) {
        int[] A = Arrays.copyOfRange(arr, low, mid + 1);
        int[] B = Arrays.copyOfRange(arr, mid + 1, high);
        int i = 0, j = 0, k = low;
        while (i < A.length && j < B.length) {
            if (reverse ? A[i] > B[j] : A[i] < B[j]) arr[k++] = A[i++];
            else arr[k++] = B[j++];
        }
        while (i < A.length) arr[k++] = A[i++];
        while (j < B.length) arr[k++] = B[j++];
    }
}
