package java.searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindFirstAndLastPositionOfTheElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N, target;
        int[] numbers;
        int testcases = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
        for (int t = 0; t < testcases; t++) {
            String[] line1 = reader.readLine().trim().split(" ");
            N = Integer.parseInt(line1[0]);
            target = Integer.parseInt(line1[1]);
            numbers = Arrays.stream(reader.readLine().trim().split(" ")).limit(N).mapToInt(Integer::parseInt).toArray();
            printFirstLastIndex(numbers, target);
        }
    }

    private static void printFirstLastIndex(int[] arr, int target) {
        int first = first(arr, target);
        if (first == -1)
            System.out.println("-1");
        else
            System.out.println(first + " " + last(arr, target));
    }

    private static int first(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target && arr[mid - 1] != target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int last(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target && arr[mid + 1] != target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
