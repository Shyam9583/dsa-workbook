package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordWrapProblem {

    public static void main(String[] args) throws IOException {
        int[] words;
        int N, WIDTH, tests;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        tests = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
        for (int test = 0; test < tests; test++) {
            N = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
            words = Arrays.stream(bufferedReader.readLine().trim().split(" ")).limit(N).mapToInt(Integer::parseInt).toArray();
            WIDTH = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
            wordWrap(words, N, WIDTH);
        }
    }

    private static void wordWrap(int[] words, int N, int WIDTH) {
        int[][] spaces = new int[N + 1][N + 1];
        int[][] cost = new int[N + 1][N + 1];
        int[] leastCost = new int[N + 1];
        int[] printable = new int[N + 1];
        final int INFINITY = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            spaces[i][i] = WIDTH - words[i - 1];
            for (int j = i + 1; j <= N; j++) {
                spaces[i][j] = spaces[i][j - 1] - words[j - 1] - 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (spaces[j][i] < 0) cost[j][i] = INFINITY;
                else if (j == N && spaces[j][i] > 0) cost[j][i] = 0;
                else cost[j][i] = spaces[j][i] * spaces[j][i];
            }
        }

        for (int i = 1; i <= N; i++) {
            leastCost[i] = INFINITY;
            for (int j = 1; j <= i; j++) {
                if (leastCost[j - 1] != INFINITY && cost[j][i] != INFINITY && leastCost[i] > cost[j][i] + leastCost[j - 1]) {
                    leastCost[i] = cost[j][i] + leastCost[j - 1];
                    printable[i] = j;
                }
            }
        }

        print(printable, N);
    }

    private static void print(int[] printable, int i) {
        if (printable[i] == 1)
            System.out.print(printable[i] + " " + i + " ");
        else {
            print(printable, printable[i] - 1);
            System.out.print(printable[i] + " " + i + " ");
        }
    }
}
