package com.technotap.dsaworkbook.bitmanipulation;

import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(findNumOfValidWords(words, puzzles));
    }

    private static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), new ArrayList<>());
        }

        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            Set<Character> distinct = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (distinct.contains(c)) continue;
                distinct.add(c);
                map.get(c).add(mask);
            }
        }

        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            char fch = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(fch);
            int count = 0;
            for (int wMask : wordsToCheck) {
                if ((wMask & mask) == wMask) {
                    ++count;
                }
            }
            result.add(count);
        }

        return result;
    }
}
