package java.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrintSortedMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases, size;
        testCases = Integer.parseInt(bufferedReader.readLine());
        for (int test = 0; test < testCases; test++) {
            size = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
            int[] inputArray = Arrays.stream(bufferedReader.readLine().trim().split(" ")).limit((long) size * size).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(inputArray);
            for (int el : inputArray) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private static void print(int[][] matrix, int size) {
        int[] rowPointers = new int[size];
        int printed = 0;
        while (printed < size * size) {
            Entry smallest = smallest(matrix, rowPointers, size);
            System.out.print(smallest.value + " ");
            rowPointers[smallest.position]++;
            printed++;
        }
    }

    private static Entry smallest(int[][] matrix, int[] p, int size) {
        int min = Integer.MAX_VALUE;
        int position = 0;
        int row = 0;
        for (int col : p) {
            if (col < size) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                    position = row;
                }
            }
            row++;
        }
        return new Entry(position, min);
    }

    private static class Entry {
        int position;
        int value;

        Entry(int position, int value) {
            this.position = position;
            this.value = value;
        }
    }
}
