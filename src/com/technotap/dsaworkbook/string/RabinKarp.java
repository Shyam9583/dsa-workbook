package com.technotap.dsaworkbook.string;

import java.util.ArrayList;

class RabinKarp {

    private static final int d = 256;

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        int q = 101;
        System.out.println(presentAt(text, pattern, q));
    }

    private static ArrayList<Integer> presentAt(String text, String pattern, int q) {
        ArrayList<Integer> positions = new ArrayList<>();
        int N = text.length(), M = pattern.length();
        long textHash = 0, patternHash = 0, highestPower = 1;
        int i, j;

        for (i = 0; i < M - 1; i++)
            highestPower = (highestPower * d) % q;

        for (i = 0; i < M; i++) {
            textHash = ((textHash * d) + text.charAt(i)) % q;
            patternHash = ((patternHash * d) + pattern.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {
            if (patternHash == textHash) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == M) {
                    positions.add(i);
                }
            }
            if (i < N - M) {
                textHash = (d * (textHash - text.charAt(i) * highestPower) + text.charAt(i + M)) % q;
                if (textHash < 0) {
                    textHash += q;
                }
            }
        }

        return positions;
    }

}