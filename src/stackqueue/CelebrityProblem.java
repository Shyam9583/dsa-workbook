package stackqueue;

import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] M = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(celebrity(M, M.length));
    }

    private static int celebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) stack.push(i);
        while (stack.size() > 1) {
            int a = stack.pop(), b = stack.pop();
            if (M[a][b] == 1) stack.push(b);
            else stack.push(a);
        }
        int last = stack.pop();
        for (int i = 0; i < n; i++) {
            if (last != i && M[i][last] == 0) return -1;
        }
        return last;
    }

}
