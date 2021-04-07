package java.string;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatedWord {
    public static void main(String[] args) {
        String text = "he had had he";
        System.out.println(first(text));
    }

    private static String first(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (frequency.get(word) != null) {
                frequency.replace(word, frequency.get(word) + 1);
            }
            frequency.putIfAbsent(word, 1);
        }

        for (String word : words) {
            if (frequency.get(word) > 1)
                return word;
        }
        return "No Repetition";
    }
}
