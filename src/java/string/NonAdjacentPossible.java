package java.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class NonAdjacentPossible {

    public static void main(String[] args) throws IOException {

        // if same count, choose lesser character.
        // else choose the higher count one
        PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) return o1.character - o2.character;
            return o2.count - o1.count;
        });
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int tests = Integer.parseInt(bufferedReader.readLine().trim().split(" ")[0]);

        for (int t = 0; t < tests; t++) {
            input = bufferedReader.readLine().trim();
            System.out.println(possible(input, input.length(), heap));
            heap.clear();
        }
    }

    private static int possible(String s, int N, PriorityQueue<Pair> heap) {
        int[] count = new int[26];
        int size = 0;
        for (int i = 0; i < N; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2)
                    return 0;
                heap.add(new Pair(count[i], (char) (i + 'a')));
            }
        }

        while (heap.size() >= 2) {
            Pair first = heap.poll();
            Pair second = heap.poll();
            size = size + 2;
            if (--first.count > 0)
                heap.add(first);
            assert second != null;
            if (--second.count > 0)
                heap.add(second);
        }
        if (!heap.isEmpty()) {
            heap.poll();
            size++;
        }
        return size == N ? 1 : 0;
    }

    private static class Pair {
        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}
