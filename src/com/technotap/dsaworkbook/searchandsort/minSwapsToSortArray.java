package com.technotap.dsaworkbook.searchandsort;

import java.util.Arrays;
import java.util.Comparator;

public class minSwapsToSortArray {
    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 4};
        System.out.println(minSwapGraph(arr, arr.length));
    }

    private static int minSwapSelectionSort(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int minIndex = i, min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (min < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                count++;
            }
        }
        return count;
    }

    private static int minSwapGraph(int[] arr, int n) {
        boolean[] visited = new boolean[arr.length];
        int[][] nodes = new int[arr.length][2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            nodes[i][0] = arr[i];
            nodes[i][1] = i;
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int j = i;
            int innerCount = 0;
            while (!visited[j]) {
                visited[j] = true;
                innerCount++;
                j = nodes[j][1];
            }
            count += innerCount - 1;
        }

        return count;
    }
}
