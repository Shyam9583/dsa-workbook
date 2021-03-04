package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeCharacters {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Char> heap = new PriorityQueue<>();
        String string;
        for (int t = 0; t < T; t++) {
            map.clear();
            heap.clear();
            string = reader.readLine().trim();
            System.out.println(rearrange(string, string.length(), map, heap));
        }
    }

    private static int rearrange(String string, int n, HashMap<Character, Integer> map, PriorityQueue<Char> heap) {
        if (n < 2) return 1;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(string.charAt(i), 0);
            int count = map.get(string.charAt(i)) + 1;
            if (count > n / 2) return 0;
            map.replace(string.charAt(i), count);
        }
        for (char c : map.keySet()) {
            heap.add(new Char(c, map.get(c)));
        }
        while (heap.size() > 1) {
            Char first = heap.poll();
            Char second = heap.poll();
            first.count--;
            assert second != null;
            second.count--;
            if (first.count > 0) heap.add(first);
            if (second.count > 0) heap.add(second);
        }
        if (heap.isEmpty()) return 1;
        Char last = heap.poll();
        return last.count > 1 ? 0 : 1;
    }

    private static class Char implements Comparable<Char> {
        char value;
        int count;

        Char(char value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Char o) {
            if (count == o.count) {
                return value - o.value;
            }
            return o.count - count;
        }
    }
}
