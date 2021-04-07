package java.backtracking;

import java.util.Arrays;

public class TugOfWar {

    private static int minDiff;

    public static void main(String[] args) {
        int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        tugOfWar(arr, arr.length);
    }

    private static void tugOfWar(int[] arr, int N) {
        boolean[] current = new boolean[N];
        boolean[] solution = new boolean[N];
        minDiff = Integer.MAX_VALUE;
        int sum = Arrays.stream(arr).sum();
        recursive(arr, N, current, solution, 0, 0, sum, 0);
        for (int i = 0; i < N; i++) {
            if (solution[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (!solution[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void recursive(int[] arr, int N, boolean[] current, boolean[] solution, int pos, int currentSum, int sum, int nSelected) {
        if (pos == N) return;
        if (N / 2 - nSelected > N - pos) return;
        recursive(arr, N, current, solution, pos + 1, currentSum, sum, nSelected);
        currentSum += arr[pos];
        nSelected++;
        current[pos] = true;
        if (nSelected == N / 2) {
            int diff = Math.abs(sum / 2 - currentSum);
            if (diff < minDiff) {
                if (N >= 0) System.arraycopy(current, 0, solution, 0, N);
            }
        } else {
            recursive(arr, N, current, solution, pos + 1, currentSum, sum, nSelected);
        }
        current[pos] = false;
    }
}
