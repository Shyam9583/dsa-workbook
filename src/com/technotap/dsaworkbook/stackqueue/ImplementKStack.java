package com.technotap.dsaworkbook.stackqueue;

import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class ImplementKStack {

    public static void main(String[] args) {
        int k = 3;
        KStack stack = new KStack(k);
        for (int i = 1; i < 9; i++) {
            stack.push((i - 1) % k, i);
        }
        for (int i = 0; i < 8; i++) {
            if (!stack.isEmpty(i % k))
                System.out.println(stack.pop(i % k));
        }
    }

    private static class KStack {
        private final int[] tops, sizes;
        private final int k;
        private int[] arr;
        private int totalCapacity, stackCapacity;

        KStack(int k) {
            this.k = k;
            this.stackCapacity = 2;
            this.totalCapacity = k * stackCapacity;
            this.arr = new int[totalCapacity];
            this.tops = new int[k];
            for (int i = 0; i < k; i++) {
                tops[i] = i * stackCapacity - 1;
            }
            this.sizes = new int[k];
        }

        private boolean stackOverflow(int stackId) {
            if (stackId < 0 || stackId >= k) throw new InputMismatchException("The Stack id is invalid");
            return sizes[stackId] == stackCapacity;
        }

        private void ensureCapacity() {
            int newStackCapacity = stackCapacity * 2;
            int newTotalCapacity = k * newStackCapacity;
            int[] newArr = new int[newTotalCapacity];
            for (int i = 0; i < k; i++) {
                if (stackCapacity >= 0)
                    System.arraycopy(arr, i * stackCapacity, newArr, i * newStackCapacity, stackCapacity);
            }
            stackCapacity = newStackCapacity;
            totalCapacity = newTotalCapacity;
            arr = newArr;
            for (int i = 0; i < k; i++)
                tops[i] = stackCapacity * i + sizes[i] - 1;
        }

        public boolean isEmpty(int stackId) throws InputMismatchException {
            if (stackId < 0 || stackId >= k) throw new InputMismatchException("The Stack id is invalid");
            return sizes[stackId] == 0;
        }

        public int peek(int stackId) {
            if (isEmpty(stackId)) throw new EmptyStackException();
            return arr[tops[stackId]];
        }

        public int pop(int stackId) {
            if (isEmpty(stackId)) throw new EmptyStackException();
            sizes[stackId]--;
            return arr[tops[stackId]--];
        }

        public void push(int stackId, int data) {
            if (stackOverflow(stackId)) ensureCapacity();
            arr[++tops[stackId]] = data;
            sizes[stackId]++;
        }
    }
}
