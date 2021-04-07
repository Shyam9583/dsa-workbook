package java.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStringLocationIn2DArray {

    private static final int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int MAX_ROW, MAX_COL, STR_LEN;

    public static void main(String[] args) throws IOException {

        char[][] chars;
        String s;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
        for (int test = 0; test < tests; test++) {
            String[] sizes = bufferedReader.readLine().trim().split(" ");
            MAX_ROW = Integer.parseInt(sizes[0]);
            MAX_COL = Integer.parseInt(sizes[1]);
            chars = new char[MAX_ROW][MAX_COL];
            char[] input = bufferedReader.readLine().trim().replace(" ", "").toCharArray();
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = 0; j < MAX_COL; j++) {
                    chars[i][j] = input[MAX_ROW * i + j];
                }
            }
            s = bufferedReader.readLine().trim();
            STR_LEN = s.length();
            printLocations(chars, s);
            System.out.println();
        }
    }

    private static void printLocations(char[][] chars, String s) {
        boolean foundNone = true;
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (foundAt(i, j, chars, s)) {
                    foundNone = false;
                    System.out.print(i + " " + j + ", ");
                }
            }
        }
        if (foundNone)
            System.out.print("-1");
    }

    private static boolean foundAt(int i, int j, char[][] chars, String s) {
        if (chars[i][j] != s.charAt(0))
            return false;
        for (int dir = 0; dir < 8; dir++) {
            int k;
            int dr = i + x[dir], dc = j + y[dir];
            for (k = 1; k < STR_LEN; k++) {
                if (dr < 0 || dr >= MAX_ROW || dc < 0 || dc >= MAX_COL)
                    break;
                if (chars[dr][dc] != s.charAt(k))
                    break;
                dr += x[dir];
                dc += y[dir];
            }
            if (k == STR_LEN)
                return true;
        }
        return false;
    }
}
