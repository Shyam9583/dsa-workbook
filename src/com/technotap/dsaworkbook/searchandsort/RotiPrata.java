package com.technotap.dsaworkbook.searchandsort;

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
            System.out.println(cooking(cooks, NC[0], P));
        }
    }

    private static int cooking(int[] arr, int N, int P) {
        int low = 0, high = (int) 1e8;
        while (low < high) {
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
                high = mid;
            }
        }
        return low;
    }

}
