package com.technotap.dsaworkbook.backtracking;

public class NQueen {

    public static void main(String[] args) {
        int n = 8;
        solve(n);
    }

    private static void solve(int n) {
        boolean[][] board = new boolean[n][n];
        SafetyTracker tracker = new SafetyTracker(n);
        if (solveRecursive(board, 0, tracker))
            printBoard(board);
        else System.out.println("Solution Doesn't exist!");
    }

    private static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean b : row) {
                System.out.print((b ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveRecursive(boolean[][] board, int row, SafetyTracker tracker) {
        if (row >= board.length) return true;
        for (int j = 0; j < board.length; j++) {
            if (tracker.isSafe(row, j)) {
                board[row][j] = true;
                tracker.setFlag(row, j, true);
                if (solveRecursive(board, row + 1, tracker))
                    return true;
                board[row][j] = false;
                tracker.setFlag(row, j, false);
            }
        }
        return false;
    }

    private static class SafetyTracker {
        boolean[] ld, rd, cl;
        int N;

        SafetyTracker(int N) {
            this.N = N;
            int size = this.N * 2;
            ld = new boolean[size];
            rd = new boolean[size];
            cl = new boolean[N];
        }

        boolean isSafe(int i, int j) {
            return !ld[i - j + N - 1] && !rd[i + j] && !cl[j];
        }

        void setFlag(int i, int j, boolean flag) {
            ld[i - j + N - 1] = rd[i + j] = cl[j] = flag;
        }
    }

}
