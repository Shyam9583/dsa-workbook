package com.technotap.dsaworkbook.trie;

import java.util.HashMap;
import java.util.Map;

public class FindShortestUniquePrefixOfEachWord {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"zebra", "dog", "duck", "dove"};
        for (String word : words) trie.insert(word);
        trie.prefixAll();
    }

    private static class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                curr.frequency++;
                curr.children.putIfAbsent(word.charAt(i), new TrieNode());
                curr = curr.children.get(word.charAt(i));
            }
            curr.frequency++;
        }

        String prefix(String word) {
            TrieNode curr = root;
            int i = 0;
            while (i < word.length() && curr.frequency > 1) {
                curr = curr.children.get(word.charAt(i++));
            }
            return word.substring(0, i);
        }

        void prefixAll() {
            prefixAllUtil(root, "");
        }

        void prefixAllUtil(TrieNode curr, String prefix) {
            if (curr == null) return;
            if (curr.frequency == 1) {
                System.out.print(prefix + " ");
                return;
            }
            for (char child : curr.children.keySet()) {
                prefixAllUtil(curr.children.get(child), prefix + child);
            }
        }

        private static class TrieNode {
            Map<Character, TrieNode> children;
            int frequency;

            TrieNode() {
                children = new HashMap<>();
                frequency = 0;
            }
        }
    }
}
