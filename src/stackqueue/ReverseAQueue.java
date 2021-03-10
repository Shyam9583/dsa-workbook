package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            q.add(i);
        }
        rev(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

    private static Queue<Integer> rev(Queue<Integer> q) {
        reverse(q);
        return q;
    }

    private static void reverse(Queue<Integer> q) {
        if (!q.isEmpty()) {
            int x = q.remove();
            reverse(q);
            q.add(x);
        }
    }
}
