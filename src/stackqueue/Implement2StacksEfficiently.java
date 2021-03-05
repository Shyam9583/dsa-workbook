package stackqueue;

import java.util.EmptyStackException;

public class Implement2StacksEfficiently {

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack();
        for (int i = 0; i < 20; i++) {
            if ((i & 1) == 0) doubleStack.push1(i);
            else doubleStack.push2(i);
        }
        while (!doubleStack.isEmpty1()) {
            System.out.println(doubleStack.pop1());
        }
        while (!doubleStack.isEmpty2()) {
            System.out.println(doubleStack.pop2());
        }
    }

    private static class DoubleStack {
        int[] arr;
        int top1, top2, size1, size2, capacity;

        DoubleStack() {
            this.capacity = 10;
            this.arr = new int[capacity];
            this.size1 = this.size2 = 0;
            this.top1 = -1;
            this.top2 = capacity / 2 - 1;
        }

        private void ensureCapacity() {
            if (size1 == capacity / 2 || size2 == capacity / 2) {
                int newCapacity = capacity * 2;
                int[] newArr = new int[newCapacity];
                for (int i = 0; i < capacity / 2; i++) {
                    newArr[i] = arr[i];
                    newArr[newCapacity / 2 + i] = arr[capacity / 2 + i];
                }
                top2 = newCapacity / 2 + size2 - 1;
                capacity = newCapacity;
                arr = newArr;
            }
        }

        public boolean isEmpty1() {
            return size1 == 0;
        }

        public boolean isEmpty2() {
            return size2 == 0;
        }

        public int peek1() {
            if (isEmpty1()) throw new EmptyStackException();
            return arr[top1];
        }

        public int peek2() {
            if (isEmpty2()) throw new EmptyStackException();
            return arr[top2];
        }

        public int pop1() {
            if (isEmpty1()) throw new EmptyStackException();
            size1--;
            return arr[top1--];
        }

        public int pop2() {
            if (isEmpty2()) throw new EmptyStackException();
            size2--;
            return arr[top2--];
        }

        public void push1(int data) {
            ensureCapacity();
            arr[++top1] = data;
            size1++;
        }

        public void push2(int data) {
            ensureCapacity();
            arr[++top2] = data;
            size2++;
        }
    }

}
