package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CreatePhoneDirectory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        Trie trie = new Trie();
        String[] names;
        String prefix;
        for (int t = 0; t < T; t++) {
            reader.readLine();
            names = reader.readLine().split(" ");
            prefix = reader.readLine();
            printDirectory(trie, names, prefix);
        }
    }

    private static void printDirectory(Trie trie, String[] names, String prefix) {
        for (String name : names) trie.insert(name);
        for (int i = 1; i <= prefix.length(); i++) {
            trie.print(prefix.substring(0, i));
        }
        trie.clear();
    }

    private static final class Trie {
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

        void clear() {
            root = new TrieNode();
        }

        void print(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length() && curr != null; i++) {
                curr = curr.children.get(prefix.charAt(i));
            }
            if (curr == null) {
                System.out.println(0);
                return;
            }
            printUtil(curr, prefix);
            System.out.println();
        }

        void printUtil(TrieNode curr, String result) {
            if (curr == null) return;
            if (curr.isWord) {
                System.out.print(result + " ");
            }
            for (char c : curr.children.keySet()) {
                printUtil(curr.children.get(c), result + c);
            }
        }

        private static class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;

            TrieNode() {
                children = new TreeMap<>();
                isWord = false;
            }
        }
    }
}
