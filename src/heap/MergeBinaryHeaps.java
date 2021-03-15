package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeBinaryHeaps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] NM, A, B;
        for (int t = 0; t < T; t++) {
            NM = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            A = Arrays.stream(reader.readLine().trim().split(" ")).limit(NM[0]).mapToInt(Integer::parseInt).toArray();
            B = Arrays.stream(reader.readLine().trim().split(" ")).limit(NM[1]).mapToInt(Integer::parseInt).toArray();
            printMerged(A, B, A.length, B.length);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private static void heapify(int[] arr, int n, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (arr[index] < arr[largest]) {
            swap(arr, index, largest);
            heapify(arr, n, largest);
        }
    }

    private static void printMerged(int[] A, int[] B, int n, int m) {
        int len = n + m;
        int[] result = new int[len];
        System.arraycopy(A, 0, result, 0, n);
        System.arraycopy(B, 0, result, n, m);
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(result, len, i);
        }
        for (int item : result) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
