package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;

public class MaximumEqualSumPossibleOf3Stacks {

    public static void main(String[] args) {
        int[] stack1 = {3, 2, 1, 1, 1};
        int[] stack2 = {4, 3, 2};
        int[] stack3 = {1, 1, 4, 1};
        System.out.println(maximumEquality(stack1, stack2, stack3));
    }

    private static int maximumEquality(int[] stack1, int[] stack2, int[] stack3) {
        int top1 = 0, top2 = 0, top3 = 0;
        int sum1 = Arrays.stream(stack1).sum();
        int sum2 = Arrays.stream(stack2).sum();
        int sum3 = Arrays.stream(stack3).sum();
        while (top1 < stack1.length && top2 < stack2.length && top3 < stack3.length) {
            if (sum1 == sum2 && sum2 == sum3) return sum1;
            switch (maxOfThree(sum1, sum2, sum3)) {
                case 0: {
                    sum1 -= stack1[top1++];
                    break;
                }
                case 1: {
                    sum2 -= stack2[top2++];
                    break;
                }
                case 2: {
                    sum3 -= stack3[top3++];
                    break;
                }
            }
        }
        return 0;
    }

    private static int maxOfThree(int a, int b, int c) {
        if (a > b && a > c) return 0;
        if (b > c) return 1;
        return 2;
    }

}
