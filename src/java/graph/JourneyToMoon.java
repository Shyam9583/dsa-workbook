package java.graph;

import java.util.Arrays;

public class JourneyToMoon {
    public static void main(String[] args) {
        int n = 100000;
        int[][] astronaut = {{1, 2}, {3, 4}};
        System.out.println(journeyToMoon(n, astronaut));
    }

    private static int journeyToMoon(int n, int[][] astronaut) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int[] pair : astronaut) {
            union(pair[0], pair[1], parent);
        }
        int[] sizes = new int[n];
        int length = 0;
        for (int p : parent) {
            if (p < 0) sizes[length++] = Math.abs(p);
        }
        int result = sizes[0] * sizes[1];
        int sum = sizes[0] + sizes[1];
        for (int i = 2; i < length; i++) {
            result += sum * sizes[i];
            sum += sizes[i];
        }
        return result;
    }

    private static int find(int current, int[] parent) {
        int root = current;
        while (parent[root] >= 0) root = parent[root];
        while (current != root) {
            int temp = parent[current];
            parent[current] = root;
            current = temp;
        }
        return root;
    }

    private static void union(int x, int y, int[] parent) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        if (parentX == parentY) return;
        if (parent[parentX] < parent[parentY]) {
            parent[parentX] += parent[parentY];
            parent[parentY] = parentX;
        } else {
            parent[parentY] += parent[parentX];
            parent[parentX] = parentY;
        }
    }
}
