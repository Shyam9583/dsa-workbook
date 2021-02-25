package greedy;

import java.util.Arrays;

public class MaximizeSumOfAiTimesI {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(maximize(arr, arr.length));
    }

    private static int maximize(int[] arr, int n) {
        int mod = (int) (10e9 + 7);
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (i * arr[i]) % (mod)) % mod;
        }
        return result;
    }
}
