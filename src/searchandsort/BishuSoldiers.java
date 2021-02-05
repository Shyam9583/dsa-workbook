package searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BishuSoldiers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(size).mapToInt(Integer::parseInt).toArray();
        int rounds = Integer.parseInt(reader.readLine());
        Arrays.sort(arr);
        int[] preSum = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            preSum[i] = arr[i - 1] + preSum[i - 1];
        }
        for (int r = 0; r < rounds; r++) {
            int power = Integer.parseInt(reader.readLine());
            if (power > arr[size - 1])
                System.out.println(size + " " + preSum[size]);
            else if (power < arr[0])
                System.out.println("0 0");
            else {
                int position = search(arr, power);
                if (position == -1) {
                    position = size - 1;
                }
                System.out.println(position + 1 + " " + preSum[position + 1]);
            }
        }
    }

    private static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length) {
                if (arr[mid] <= key && arr[mid + 1] > key) {
                    return mid;
                } else if (arr[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else break;
        }
        return -1;
    }
}
