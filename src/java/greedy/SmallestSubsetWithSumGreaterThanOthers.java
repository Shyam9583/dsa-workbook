package java.greedy;

import java.util.Arrays;
import java.util.Collections;

public class SmallestSubsetWithSumGreaterThanOthers {

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 2};
        System.out.println(smallestSubsetSize(arr, arr.length));
    }

    private static int smallestSubsetSize(Integer[] arr, int n) {
        int halfSum = Arrays.stream(arr).reduce(0, Integer::sum) / 2;
        int result = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            result++;
            if (sum > halfSum) return result;
        }
        return result;
    }

}
