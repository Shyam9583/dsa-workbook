package java.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(isPossible(s));
    }

    private static String isPossible(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            count.putIfAbsent(c, 0);
            count.replace(c, count.get(c) + 1);
        }
        for (char c : count.keySet()) {
            heap.add(new Node(c, count.get(c)));
        }
        Node prev = new Node('#', -1);
        while (!heap.isEmpty()) {
            Node curr = heap.remove();
            result.append(curr.val);
            if (prev.cnt > 0) heap.add(prev);
            curr.cnt--;
            prev = curr;
        }
        return result.length() == s.length() ? result.toString() : "";
    }

    private static class Node implements Comparable<Node> {
        char val;
        int cnt;

        Node(char val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (cnt == o.cnt) return val - o.val;
            return o.cnt - cnt;
        }
    }
}
