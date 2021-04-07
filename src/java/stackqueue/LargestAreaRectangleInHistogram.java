package java.stackqueue;

import java.util.Stack;

public class LargestAreaRectangleInHistogram {

    public static void main(String[] args) {
        long[] arr = {
                436, 832, 55, 324, 356, 967,
                131, 999, 192, 212, 649, 646,
                127, 710, 65, 125, 234, 39, 287,
                256, 557, 954, 475, 471, 5, 847,
                168, 571, 380, 983, 520, 536, 420,
                529, 121, 464, 695, 137, 484, 519,
                404, 585, 829, 841, 859, 724, 862,
                14, 429, 190, 341, 45, 901, 75, 347,
                959, 705, 967, 727, 156, 901, 943,
                439, 907, 857, 422, 998, 585, 999,
                806, 290, 811, 33, 512, 32, 393, 952,
                944, 748, 396, 369, 450, 720, 20, 962,
                452, 920, 196, 665, 399, 850, 642, 351,
                268, 983, 367, 897, 760, 127, 113
        };
        System.out.println(largestArea(arr, arr.length));
    }

    private static long largestArea(long[] hist, long n) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        for (int i = 0; i < n; ) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long area = hist[top] * (i - (stack.isEmpty() ? 0 : stack.peek()));
                max = Math.max(max, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = hist[top] * (n - (stack.isEmpty() ? 0 : stack.peek()));
            max = Math.max(max, area);
        }
        return max;
    }
}
