package searchandsort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DoubleHelix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] NA = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] MB = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxSum(Arrays.copyOfRange(NA, 1, NA[0] + 1), Arrays.copyOfRange(MB, 1, MB[0] + 1), NA[0], MB[0]));
    }

    private static int maxSum(int[] A, int[] B, int N, int M) {
        int sum = 0, result = 0;
        int[] prefixSumA = new int[N], prefixSumB = new int[M];
        int[] intersectionsA = new int[N + 1], intersectionsB = new int[M + 1];
        int intersectionPtr = 1;

        for (int i = 0; i < N; i++) {
            sum += A[i];
            prefixSumA[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < M; i++) {
            sum += B[i];
            prefixSumB[i] = sum;
        }

        for (int i = 0; i < N; i++) {
            int position = binarySearch(B, A[i]);
            if (position != -1) {
                intersectionsA[intersectionPtr] = prefixSumA[i];
                intersectionsB[intersectionPtr] = prefixSumB[position];
                intersectionPtr++;
            }
        }

        intersectionsA[intersectionPtr] = prefixSumA[N - 1];
        intersectionsB[intersectionPtr] = prefixSumB[M - 1];

        for (int i = 1; i <= intersectionPtr; i++) {
            result += Math.max(intersectionsA[i] - intersectionsA[i - 1], intersectionsB[i] - intersectionsB[i - 1]);
        }

        return result;
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
