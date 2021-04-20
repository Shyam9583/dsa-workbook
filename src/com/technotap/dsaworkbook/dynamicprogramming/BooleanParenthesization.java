package com.technotap.dsaworkbook.dynamicprogramming;

public class BooleanParenthesization {
    private static final int M = 1003;

    public static void main(String[] args) {
        String S = "F|T^T|T|F^F^F|T&T|F^T|F^F^F&T|T^F&T|F&T^T^T&F|T&T^F^F|T&T&F^T^T|T&T^T&T&T^T^F^F^T|F&T^T&F|T&T&F^F&F&F^T^T^F&F&T^T^F^T^F&F|F^F&T|F&F&T&F&F|T^T&T^T&T&F&T|T^T^T|F|F|T|T|F&F&T^T|T^F^T^T^F|F|T^F|T&T^T&F";
        System.out.println(countWays(S.length(), S));
    }

    private static int countWays(int N, String S) {
        char[] chars = S.toCharArray();
        int[][] ts = new int[N][N], fs = new int[N][N];
        for (int g = 0; g < N; g += 2) {
            for (int i = 0, j = g; j < N; i += 2, j += 2) {
                if (g == 0) {
                    if (chars[i] == 'T') {
                        ts[i][j] = 1;
                    } else {
                        fs[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k += 2) {
                        int tl = ts[i][k], tb = ts[k + 2][j], fl = fs[i][k], fb = fs[k + 2][j];
                        char op = chars[k + 1];
                        if (op == '&') {
                            ts[i][j] += (tl * tb) % M;
                            fs[i][j] += ((tl * fb) + (fl * tb) + (fl * fb)) % M;
                        } else if (op == '|') {
                            ts[i][j] += ((tl * fb) + (fl * tb) + (tl * tb)) % M;
                            fs[i][j] += (fl * fb) % M;
                        } else {
                            ts[i][j] += ((tl * fb) + (fl * tb)) % M;
                            fs[i][j] += ((tl * tb) + (fl * fb)) % M;
                        }
                    }
                }
            }
        }
        return ts[0][N - 1] % M;
    }
}
