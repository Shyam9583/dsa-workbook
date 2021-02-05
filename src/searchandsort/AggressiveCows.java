package searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; t++) {
            int[] NC = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            int[] stalls = new int[NC[0]];
            for (int n = 0; n < NC[0]; n++)
                stalls[n] = Integer.parseInt(reader.readLine());
            maximumPossibleDistance(stalls, NC[0], NC[1]);
        }
    }

    private static void maximumPossibleDistance(int[] stalls, int n, int c) {
        Arrays.sort(stalls);
        int low = stalls[0], high = stalls[n - 1], best = 0;
        while (low <= high) {
            int mid = (low + high + 1) / 2;
            int cnt = 1, left = 0;
            for (int i = 1; i < n; i++) {
                if (stalls[i] - stalls[left] >= mid) {
                    cnt++;
                    left = i;
                }
            }
            if (cnt >= c) {
                if (best < mid)
                    best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(best);
    }

}
