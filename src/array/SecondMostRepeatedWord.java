package array;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedWord {
    public static void main(String[] args) {
        String[] words = {"geek", "for", "geek", "for", "geek", "aaa"};
        System.out.println(secondMost(words));
    }

    private static String secondMost(String[] words) {
        Map<String, Integer> frequency = new HashMap<>();
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        String result = "";
        for (String word : words) {
            if (frequency.get(word) != null)
                frequency.replace(word, frequency.get(word) + 1);
            frequency.putIfAbsent(word, 1);
        }
        for (String word : frequency.keySet()) {
            int count = frequency.get(word);
            if (count > first) {
                first = count;
            } else if (count > second && count < first) {
                second = count;
                result = word;
            }
        }
        return result;
    }
}
