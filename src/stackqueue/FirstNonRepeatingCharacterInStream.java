package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStream {
    public static void main(String[] args) {
        String s = "zz";
        System.out.println(firstNonRepeating(s));
    }

    private static String firstNonRepeating(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        Queue<Character> deque = new LinkedList<>();
        for (char c : arr) {
            count[c - 'a']++;
            if (count[c - 'a'] > 1) {
                deque.remove(c);
            } else {
                deque.add(c);
            }
            if (deque.isEmpty()) builder.append('#');
            else builder.append(deque.peek());
        }
        return builder.toString();
    }
}
