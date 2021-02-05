package searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotiPrata {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; t++) {
            int P = Integer.parseInt(reader.readLine());
            int[] NC = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] cooks = Arrays.copyOfRange(NC, 1, NC[0] + 1);
            System.out.println(optimizedCooking(cooks, NC[0], P));
        }
    }

    private static int optimizedCooking(int[] arr, int N, int P) {
        int low = 0, high = (int) 1e8;
        int best = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prepared = 0;
            for (int i = 0; i < N; i++) {
                int time = arr[i];
                for (int j = 2; time <= mid; j++) {
                    prepared++;
                    time += arr[i] * j;
                }
            }
            if (prepared < P) {
                low = mid + 1;
            } else {
                if (best > mid)
                    best = mid;
                high = mid - 1;
            }
        }
        return best;
    }

    private static int timeForCooking(int[] arr, int N, int P) {
        Arrays.sort(arr);
        Cook[] cooks = new Cook[N];
        for (int i = 0; i < N; i++) {
            cooks[i] = new Cook(arr[i]);
        }
        int prepared = 0, time = 0;
        while (true) {
            for (int i = 0; i < N; i++) {
                if (cooks[i].isOccupied) {
                    if (time >= cooks[i].next) {
                        cooks[i].isOccupied = false;
                        prepared++;
                        if (prepared == P)
                            break;
                    }
                }
                if (!cooks[i].isOccupied) {
                    cooks[i].setNext(time);
                }
            }
            if (prepared == P) {
                break;
            }
            time++;
        }
        return time;
    }

    private static class Cook {
        boolean isOccupied;
        int next, initial, i = 1;

        Cook(int initial) {
            this.initial = initial;
        }

        void setNext(int time) {
            isOccupied = true;
            next = time + i * initial;
            i++;
        }
    }

}
