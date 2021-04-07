package java.backtracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(findPath(maze, maze.length));
    }

    private static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> result = new ArrayList<>();
        traverse(maze, 0, 0, n, "", result);
        result.sort(String::compareTo);
        return result;
    }

    private static void traverse(int[][] maze, int i, int j, int n, String path, ArrayList<String> result) {
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1 || maze[i][j] == 0) return;
        if (i == n - 1 && j == n - 1) result.add(path);
        maze[i][j] = 0;
        traverse(maze, i - 1, j, n, path + "U", result);
        traverse(maze, i + 1, j, n, path + "D", result);
        traverse(maze, i, j - 1, n, path + "L", result);
        traverse(maze, i, j + 1, n, path + "R", result);
        maze[i][j] = 1;
    }
}
