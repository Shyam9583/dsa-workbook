package java.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gergovia {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        long[] arr;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            arr = Arrays.stream(reader.readLine().trim().split(" ")).limit(n).mapToLong(Long::parseLong).toArray();
            System.out.println(work(arr, n));
        }
    }

    private static long work(long[] arr, int n) {
        long result = 0, temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp += arr[i];
            result += Math.abs(temp);
        }
        return result;
    }

}
