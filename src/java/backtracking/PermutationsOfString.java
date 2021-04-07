package java.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PermutationsOfString {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        String s;
        for (int t = 0; t < T; t++) {
            s = reader.readLine();
            printPermutations(s, 0, s.length() - 1);
            System.out.println();
        }
    }

    private static void printPermutations(String s, int l, int r) {
        if (l == r) {
            System.out.print(s + " ");
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                printPermutations(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    private static String swap(String s, int i, int j) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
