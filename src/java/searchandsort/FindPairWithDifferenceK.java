package java.searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithDifferenceK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int size, k;
        int[] arr;
        int testcases = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
        for (int t = 0; t < testcases; t++) {
            int[] line1 = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            size = line1[0];
            k = line1[1];
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(size).mapToInt(Integer::parseInt).toArray();
            if (differenceExists(arr, k, map))
                System.out.println("1");
            else
                System.out.println("-1");
            map.clear();
        }
    }

    private static boolean differenceExists(int[] arr, int k, Map<Integer, Integer> map) {
        for (int el : arr) {
            map.putIfAbsent(el, 1);
        }
        for (int el : arr) {
            if (map.containsKey(el - k))
                return true;
        }
        return false;
    }
}
