package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseKElementsInQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int n = 5, k = 3;
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        modifyQueue(q, k);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

    private static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        reverse(q, k);
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
        return q;
    }

    private static void reverse(Queue<Integer> q, int k) {
        if (q.isEmpty()) return;
        if (k > 0) {
            int x = q.remove();
            reverse(q, k - 1);
            q.add(x);
        }
    }
}
