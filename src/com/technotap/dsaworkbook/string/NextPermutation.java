package com.technotap.dsaworkbook.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) throws IOException {
        int[] numbers;
        int N, tests;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        tests = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
        for (int test = 0; test < tests; test++) {
            N = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);
            numbers = new int[N];
            String[] input = bufferedReader.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            nextPermutation(numbers, N);
            for (int n : numbers) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static void nextPermutation(int[] numbers, int N) {
        int target = N - 1;
        while (target > 0) {
            if (numbers[target] > numbers[target - 1])
                break;
            target--;
        }
        if (target == 0) {
            Arrays.sort(numbers);
        } else {
            int x = numbers[target - 1], smallest = target;
            for (int i = target + 1; i < N; i++) {
                if (numbers[i] > x && numbers[smallest] > numbers[i]) {
                    smallest = i;
                }
            }
            int temp = numbers[target - 1];
            numbers[target - 1] = numbers[smallest];
            numbers[smallest] = temp;
            Arrays.sort(numbers, target, N);
        }
    }
}
