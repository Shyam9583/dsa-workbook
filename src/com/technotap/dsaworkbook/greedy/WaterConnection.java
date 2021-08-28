package com.technotap.dsaworkbook.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class WaterConnection {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>(), d = new ArrayList<>();
        Collections.addAll(a, 1, 2);
        Collections.addAll(b, 2, 3);
        Collections.addAll(d, 1, 99);
        int n = 3, p = 2;
        solve(n, p, a, b, d).forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < p; i++) {
            nodes[a.get(i) - 1].next = nodes[b.get(i) - 1];
            nodes[b.get(i) - 1].prev = nodes[a.get(i) - 1];
            nodes[a.get(i) - 1].value = d.get(i);
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i].prev != null) continue;
            if (nodes[i].next == null) continue;
            int end = 0;
            int min = Integer.MAX_VALUE;
            for (Node curr = nodes[i]; curr != null; curr = curr.next) {
                min = Math.min(min, curr.value);
                end = curr.index;
            }
            ArrayList<Integer> pipe = new ArrayList<>();
            pipe.add(i + 1);
            pipe.add(end);
            pipe.add(min);
            result.add(pipe);
        }
        return result;
    }

    private static class Node {
        int value = Integer.MAX_VALUE, index;
        Node prev = null, next = null;

        Node(int index) {
            this.index = index;
        }
    }
}
