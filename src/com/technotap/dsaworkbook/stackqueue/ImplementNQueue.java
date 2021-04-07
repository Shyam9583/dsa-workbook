package com.technotap.dsaworkbook.stackqueue;

import java.security.InvalidParameterException;

public class ImplementNQueue {
    public static void main(String[] args) throws Exception {
        int n = 3;
        NQueue q = new NQueue(n);
        q.enqueue(0, 1);
        q.enqueue(0, 2);
        q.enqueue(0, 3);
        q.enqueue(1, 4);
        q.enqueue(1, 5);
        q.enqueue(1, 6);
        q.enqueue(2, 7);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty(i)) {
                System.out.println(q.dequeue(i));
            }
        }
    }

    private static class NQueue {

        private final int[] front, rear, size;
        private final int n;
        private int[] arr;
        private int queueCapacity;

        NQueue(int n) {
            this.n = n;
            queueCapacity = 2;
            front = new int[n];
            rear = new int[n];
            size = new int[n];
            arr = new int[queueCapacity * n];
            for (int i = 0; i < n; i++) {
                front[i] = queueCapacity * i;
                rear[i] = front[i] - 1;
            }
        }

        boolean isEmpty(int id) {
            handleInvalidId(id);
            return size[id] == 0;
        }

        private boolean isFull(int id) {
            handleInvalidId(id);
            return size[id] == queueCapacity;
        }

        private void handleInvalidId(int id) {
            if (id < 0 || id >= n)
                throw new InvalidParameterException("invalid id");
        }

        private void ensureCapacity() {
            int newCapacity = queueCapacity * 2;
            int[] newArray = new int[newCapacity * n];
            for (int i = 0; i < n; i++) {
                if (size[i] >= 0) System.arraycopy(arr, front[i], newArray, i * newCapacity, size[i]);
                front[i] = newCapacity * i;
                rear[i] = front[i] + size[i] - 1;
            }
            queueCapacity = newCapacity;
            arr = newArray;
        }

        void enqueue(int id, int data) {
            if (isFull(id)) ensureCapacity();
            arr[++rear[id]] = data;
            size[id]++;
        }

        int dequeue(int id) throws Exception {
            if (isEmpty(id)) throw new Exception("empty queue");
            int data = arr[front[id]];
            if (front[id] == rear[id]) {
                resetPointers(id);
            } else {
                front[id]++;
            }
            size[id]--;
            return data;
        }

        int peek(int id) throws Exception {
            if (isEmpty(id)) throw new Exception("empty queue");
            return arr[front[id]];
        }

        private void resetPointers(int id) {
            front[id] = queueCapacity * id;
            rear[id] = front[id] - 1;
            arr[front[id]] = 0;
        }
    }
}
