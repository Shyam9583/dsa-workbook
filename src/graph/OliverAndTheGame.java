package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OliverAndTheGame {

    private static int kingIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < N; i++) {
            int[] road = Arrays.stream(reader.readLine().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            adj.get(road[0]).add(road[1]);
        }
        int[] sort = sort(N, adj);
        int Q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < Q; i++) {
            int[] q = Arrays.stream(reader.readLine().split(" ")).limit(3).mapToInt(Integer::parseInt).toArray();
            System.out.println(find(q[0], q[2], q[1], sort) ? "YES" : "NO");
        }
    }

    private static boolean find(int direction, int src, int dst, int[] sort) {
        int srcIndex = 0, dstIndex = 0;
        for (int i = 1; i < sort.length; i++) {
            if (sort[i] == src) srcIndex = i;
            if (sort[i] == dst) dstIndex = i;
        }
        if (kingIndex < srcIndex) {
            if (direction == 0) {
                return dstIndex >= kingIndex && dstIndex < srcIndex;
            }
            return dstIndex > srcIndex;
        }
        if (direction == 0) {
            return dstIndex <= kingIndex && dstIndex > srcIndex;
        }
        return dstIndex < srcIndex;
    }

    private static int[] sort(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[n + 1];
        int[] result = new int[n + 1];
        int ptr = 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int node : adj.get(i)) {
                inDegree[node]++;
            }
        }
        for (int i = 1; i < n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int current = q.remove();
            if (current == 1) kingIndex = ptr;
            result[ptr++] = current;
            for (int neighbor : adj.get(current)) {
                if (--inDegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return result;
    }
}
