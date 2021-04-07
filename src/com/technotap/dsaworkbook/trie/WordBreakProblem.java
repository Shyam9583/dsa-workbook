package com.technotap.dsaworkbook.trie;

import java.util.HashMap;
import java.util.Map;

public class WordBreakProblem {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        for (String word : words) trie.insert(word);
        System.out.println(trie.wordBreak("ilikesamsung"));
    }

    private static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                curr.children.putIfAbsent(word.charAt(i), new TrieNode());
                curr = curr.children.get(word.charAt(i));
            }
            curr.isWord = true;
        }

        boolean contains(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length() && curr != null; i++) {
                curr = curr.children.get(word.charAt(i));
            }
            return curr != null && curr.isWord;
        }

        boolean wordBreak(String word) {
            int size = word.length();
            if (size == 0) return true;
            for (int i = 1; i <= size; i++) {
                if (contains(word.substring(0, i)) && wordBreak(word.substring(i))) {
                    return true;
                }
            }
            return false;
        }

        private static class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;

            TrieNode() {
                children = new HashMap<>();
                isWord = false;
            }
        }
    }
}
