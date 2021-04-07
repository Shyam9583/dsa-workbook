package java.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PickingUpChicks {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(reader.readLine());
        int[] position, speed, NKBT;
        for (int c = 0; c < C; c++) {
            NKBT = Arrays.stream(reader.readLine().trim().split(" ")).limit(4).mapToInt(Integer::parseInt).toArray();
            position = Arrays.stream(reader.readLine().trim().split(" ")).limit(NKBT[0]).mapToInt(Integer::parseInt).toArray();
            speed = Arrays.stream(reader.readLine().trim().split(" ")).limit(NKBT[0]).mapToInt(Integer::parseInt).toArray();
            System.out.println("Case #" + (c + 1) + ": " + swapsNeeded(position, speed, NKBT[0], NKBT[1], NKBT[2], NKBT[3]));
        }
    }

    private static String swapsNeeded(int[] position, int[] speed, int N, int K, int B, int T) {
        boolean[] isFastEnough = new boolean[N];
        int swaps = 0, swapCost = 0, finishers = 0;
        for (int i = 0; i < N; i++) {
            if (position[i] + T * speed[i] >= B) {
                isFastEnough[i] = true;
                finishers++;
            } else {
                isFastEnough[i] = false;
            }
        }
        if (finishers < K)
            return "IMPOSSIBLE";
        finishers = 0;
        for (int i = N - 1; i > -1; i--) {
            if (isFastEnough[i]) {
                finishers++;
                swaps += swapCost;
            } else {
                swapCost++;
            }
            if (finishers == K)
                return String.valueOf(swaps);
        }
        return String.valueOf(swaps);
    }
}
