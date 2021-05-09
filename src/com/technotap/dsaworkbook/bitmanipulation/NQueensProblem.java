package com.technotap.dsaworkbook.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueensProblem {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    private static List<List<String>> solution(int n) {
        List<List<String>> result = new ArrayList<>();
        SafetyChecker checker = new SafetyChecker(n);
        StringBuilder[] board = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            board[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                board[i].append('.');
            }
        }
        solutionRec(board, checker, 0, result);
        return result;
    }

    private static void solutionRec(StringBuilder[] board, SafetyChecker checker, int i, List<List<String>> result) {
        if (i == board.length) {
            result.add(Arrays.stream(board)
                    .map(builder -> "\"" + builder.toString() + "\"")
                    .collect(Collectors.toList()));
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (!checker.isSafe(i, j)) continue;
            checker.setFlag(i, j, true);
            board[i].setCharAt(j, 'Q');
            solutionRec(board, checker, i + 1, result);
            board[i].setCharAt(j, '.');
            checker.setFlag(i, j, false);
        }
    }

    private static class SafetyChecker {
        private final boolean[] ld, rd, cl;
        private final int n;

        SafetyChecker(int n) {
            int size = n * 2;
            this.n = n;
            ld = new boolean[size];
            rd = new boolean[size];
            cl = new boolean[n];
        }

        boolean isSafe(int i, int j) {
            return !(ld[i - j + n - 1] || rd[i + j] || cl[j]);
        }

        void setFlag(int i, int j, boolean flag) {
            ld[i - j + n - 1] = rd[i + j] = cl[j] = flag;
        }
    }
}
