package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };

        System.out.println(Arrays.toString(commonElement(matrix)));
    }

    private static int[] commonElement(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        ArrayList<Integer> values = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(matrix[0][i], 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(matrix[i][j])) {
                    int value = map.get(matrix[i][j]);
                    if (value <= i) {
                        map.replace(matrix[i][j], value + 1);
                    }
                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == m)
                values.add(key);
        }

        return values.stream().mapToInt(Integer::valueOf).toArray();
    }
}
