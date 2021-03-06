package stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 4};
        System.out.println(Arrays.toString(nextGreaterElement(arr, arr.length)));
    }

    private static long[] nextGreaterElement(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] result = new long[n];
        for (int i = 0; i < n; ) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i])
                stack.push(i++);
            else result[stack.pop()] = arr[i];
        }
        while (!stack.isEmpty()) result[stack.pop()] = -1;
        return result;
    }
}
