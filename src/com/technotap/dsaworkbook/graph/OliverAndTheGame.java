package com.technotap.dsaworkbook.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class OliverAndTheGame {

    private static int time;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < N; i++) {
            int[] road = Arrays.stream(reader.readLine().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            adj.get(road[0]).add(road[1]);
        }
        time = 0;
        int[] inTime = new int[N + 1], outTime = new int[N + 1];
        dfs(1, inTime, outTime, adj);
        int Q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < Q; i++) {
            int[] q = Arrays.stream(reader.readLine().split(" ")).limit(3).mapToInt(Integer::parseInt).toArray();
            if (!check(q[1], q[2], inTime, outTime) && !check(q[2], q[1], inTime, outTime)) {
                System.out.println("NO");
                continue;
            }
            if (q[0] == 0) {
                System.out.println(check(q[2], q[1], inTime, outTime) ? "YES" : "NO");
            } else if (q[0] == 1) {
                System.out.println(check(q[1], q[2], inTime, outTime) ? "YES" : "NO");
            }
        }
    }

    private static boolean check(int X, int Y, int[] inTime, int[] outTime) {
        return inTime[Y] < inTime[X] && outTime[Y] > outTime[X];
    }

    private static void dfs(int src, int[] inTime, int[] outTime, ArrayList<ArrayList<Integer>> adj) {
        inTime[src] = ++time;
        for (int neighbor : adj.get(src)) {
            if (inTime[neighbor] == 0) dfs(neighbor, inTime, outTime, adj);
        }
        outTime[src] = ++time;
    }

}
