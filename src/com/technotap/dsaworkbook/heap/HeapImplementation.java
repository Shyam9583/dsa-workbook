package com.technotap.dsaworkbook.heap;

import java.util.Arrays;

public class HeapImplementation {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.add(5);
        heap.add(4);
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }

    private static class MaxHeap {
        private int size, capacity;
        private int[] items;

        MaxHeap() {
            capacity = 5;
            size = 0;
            items = new int[capacity];
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private int getParent(int index) {
            return items[getParentIndex(index)];
        }

        private int getLeftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        private int getRightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        private void ensureCapacity() {
            if (size == capacity) {
                items = Arrays.copyOf(items, 2 * capacity);
                capacity *= 2;
            }
        }

        private void swap(int i1, int i2) {
            int temp = items[i1];
            items[i1] = items[i2];
            items[i2] = temp;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }

        int peek() {
            if (isEmpty()) throw new IllegalStateException();
            return items[0];
        }

        int remove() {
            int data = peek();
            if (size > 1) {
                swap(0, size - 1);
            }
            size--;
            heapifyDown();
            return data;
        }

        void add(int data) {
            ensureCapacity();
            items[size++] = data;
            heapifyUp();
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int largerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getLeftChild(index) < getRightChild(index)) {
                    largerChildIndex = getRightChildIndex(index);
                }
                if (items[index] >= items[largerChildIndex]) break;
                swap(index, largerChildIndex);
                index = largerChildIndex;
            }
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && getParent(index) < items[index]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }
    }

    private static class MinHeap {
        private int size, capacity;
        private int[] items;

        MinHeap() {
            capacity = 5;
            size = 0;
            items = new int[capacity];
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private int getParent(int index) {
            return items[getParentIndex(index)];
        }

        private int getLeftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        private int getRightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        private void ensureCapacity() {
            if (size == capacity) {
                items = Arrays.copyOf(items, 2 * capacity);
                capacity *= 2;
            }
        }

        private void swap(int i1, int i2) {
            int temp = items[i1];
            items[i1] = items[i2];
            items[i2] = temp;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }

        int peek() {
            if (isEmpty()) throw new IllegalStateException();
            return items[0];
        }

        int remove() {
            int data = peek();
            if (size > 1) {
                swap(0, size - 1);
            }
            size--;
            heapifyDown();
            return data;
        }

        void add(int data) {
            ensureCapacity();
            items[size++] = data;
            heapifyUp();
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallestChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getLeftChild(index) > getRightChild(index)) {
                    smallestChildIndex = getRightChildIndex(index);
                }
                if (items[smallestChildIndex] > items[index]) break;
                swap(index, smallestChildIndex);
                index = smallestChildIndex;
            }
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && getParent(index) > items[index]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }
    }
}
