package com.technotap.dsaworkbook.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, words);
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                String curr = queue.remove();
                if (visited.contains(curr)) continue;
                if (curr.equals(endWord)) return length;
                visited.add(curr);
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String temp = curr.substring(0, j) + c + curr.substring(j + 1);
                        if (set.contains(temp) && !visited.contains(temp)) {
                            queue.add(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
