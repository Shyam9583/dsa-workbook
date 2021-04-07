package java.trie;

import java.util.*;

public class PrintAnagrams {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "tac", "god", "act", "gdo"};
        System.out.println(anagrams(words));
    }

    private static List<List<String>> anagrams(String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        List<List<String>> result = new ArrayList<>();
        trie.listAnagrams(result);
        return result;
    }

    private static class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            TrieNode curr = root;
            for (char c : chars) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            if (curr.anagrams == null) {
                curr.anagrams = new ArrayList<>();
            }
            curr.anagrams.add(word);
        }

        void listAnagrams(List<List<String>> result) {
            listAnagramsUtil(root, result);
        }

        void listAnagramsUtil(TrieNode curr, List<List<String>> result) {
            if (curr == null) return;
            if (curr.anagrams != null) {
                result.add(curr.anagrams);
                return;
            }
            for (char c : curr.children.keySet()) {
                listAnagramsUtil(curr.children.get(c), result);
            }
        }

        private static class TrieNode {
            Map<Character, TrieNode> children;
            List<String> anagrams;

            TrieNode() {
                children = new HashMap<>();
                anagrams = null;
            }
        }
    }
}
