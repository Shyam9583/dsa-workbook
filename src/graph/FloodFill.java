package graph;

import java.util.Arrays;

public class FloodFill {

    private static final int[] addR = {-1, 1, 0, 0};
    private static final int[] addC = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        floodFillDFS(image, sr, sc, newColor);
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int N = image.length, M = image[0].length;
        int color = image[sr][sc];
        floodFillRec(image, sr, sc, color, newColor, N, M);
        return image;
    }

    private static void floodFillRec(int[][] image, int r, int c, int color, int newColor, int N, int M) {
        if (image[r][c] != color || image[r][c] == newColor) return;
        image[r][c] = newColor;
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + addR[dir];
            int nc = c + addC[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            floodFillRec(image, nr, nc, color, newColor, N, M);
        }
    }

    private static class Pixel {
        int r, c;

        Pixel(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
