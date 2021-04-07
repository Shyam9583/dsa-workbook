package com.technotap.dsaworkbook.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class WordBreakProblem {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()), N;
        String[] dict;
        String string;
        HashSet<String> set = new HashSet<>();
        for (int t = 0; t < T; t++) {
            set.clear();
            N = Integer.parseInt(reader.readLine());
            dict = Arrays.copyOf(reader.readLine().trim().split(" "), N);
            string = reader.readLine().trim();
            printSentences(dict, string, set);
        }
    }

    private static void printSentences(String[] dict, String string, HashSet<String> set) {
        Collections.addAll(set, dict);
        ArrayList<String> sentences = new ArrayList<>();
        recursiveUtil(set, sentences, string, "");
        sentences.sort(String::compareTo);
        for (String sentence : sentences) {
            System.out.print("(" + sentence + ")");
        }
        System.out.println();
    }

    private static void recursiveUtil(HashSet<String> set, ArrayList<String> sentences, String original, String result) {
        if (original.length() == 0) {
            sentences.add(result.trim());
        }
        for (int i = 1; i < original.length() + 1; i++) {
            if (set.contains(original.substring(0, i))) {
                recursiveUtil(set, sentences, original.substring(i), result + original.substring(0, i) + " ");
            }
        }
    }

}
