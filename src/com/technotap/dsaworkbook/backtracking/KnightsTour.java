package com.technotap.dsaworkbook.backtracking;

public class KnightsTour {

    public static void main(String[] args) {
        int N = 8;
        knightsTour(N);
    }

    private static void knightsTour(int N) {
        int[][] board = new int[N][N];
        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if (knightsTourUtil(board, N, 0, 0, 1, moveX, moveY))
            printBoard(board, N);
        else
            System.out.println("The knight's tour failed!");
    }

    private static void printBoard(int[][] board, int N) {
        for (int[] row : board) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static boolean knightsTourUtil(int[][] board, int N, int x, int y, int counter, int[] moveX, int[] moveY) {
        if (counter >= N * N) return true;
        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i], nextY = y + moveY[i];
            if (isValid(nextX, nextY, board, N)) {
                board[nextX][nextY] = counter;
                if (knightsTourUtil(board, N, nextX, nextY, counter + 1, moveX, moveY))
                    return true;
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int[][] board, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

}
