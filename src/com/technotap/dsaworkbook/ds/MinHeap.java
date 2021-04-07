package com.technotap.dsaworkbook.ds;

import java.util.Arrays;

public class MinHeap {
    int size = 0;
    int capacity = 10;
    int[] items = new int[capacity];

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int getParent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }


    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, 2 * capacity);
            capacity *= 2;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        if (size > 1) {
            items[0] = items[size - 1];
        }
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && items[smallerChildIndex] > getRightChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[smallerChildIndex] > items[index]) {
                break;
            } else {
                swap(smallerChildIndex, index);
            }
            index = smallerChildIndex;
        }
    }
}
