package trie;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueRowsOfMatrix {
    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1}
        };
        int r = 4, c = 7;
        System.out.println(uniqueRow(a, r, c));
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int[][] a, int r, int c) {
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < r; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < c; j++) {
                builder.append(a[i][j]);
            }
            set.add(builder.toString());
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (String row : set) {
            ArrayList<Integer> list = new ArrayList<>();
            for (char character : row.toCharArray()) {
                list.add(character - '0');
            }
            result.add(list);
        }
        return result;
    }
}
