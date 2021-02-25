package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximizeSumOfDifferences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()), N;
        int[] arr;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(reader.readLine());
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(N).mapToInt(Integer::parseInt).toArray();
            System.out.println(maximize(arr, N));
        }
    }

    private static int maximize(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, j = n - 1, sum = 0;
        while (i < j) {
            sum += arr[j] - arr[i++];
            sum += arr[j--] - arr[i];
        }
        return sum + (arr[i] - arr[0]);
    }
}
