package com.technotap.dsaworkbook.stackqueue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimizeCountInString {
    public static void main(String[] args) {
        String s = "aabcbcbcabcc";
        int k = 3;
        System.out.println(minimize(s, k));
    }

    private static int minimize(String s, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        HashMap<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count.putIfAbsent(c, 0);
            count.put(c, count.get(c) + 1);
        }
        for (char key : count.keySet()) {
            heap.add(new Node(key, count.get(key)));
        }
        while (!heap.isEmpty() && k-- > 0) {
            Node max = heap.remove();
            max.cnt--;
            heap.add(max);
        }
        return heap.stream().map(node -> node.cnt * node.cnt).reduce(0, Math::addExact);
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
