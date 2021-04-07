package com.technotap.dsaworkbook.trie;

import java.util.HashMap;
import java.util.Map;

public class ConstructTrie {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "ant", "ball", "bangles", "antarctica"};
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        System.out.println(trie.contains("ant"));
        System.out.println(trie.contains("applet"));
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
