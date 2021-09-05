package com.technotap.dsaworkbook.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class WindowsFolderNaming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        process(input);
        reader.close();
    }

    private static void process(String input) {
        String[] commands = input.split(" ");
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> missing = new PriorityQueue<>();
        for (String command : commands) {
            String op = command.substring(0, 2);
            int number = Integer.parseInt(command.substring(2));
            if (op.equals("IN")) {
                while (number > 0 && !missing.isEmpty()) {
                    set.add(missing.remove());
                    --number;
                }
                int next = set.size();
                while (number-- > 0) set.add(++next);
            } else {
                if (set.contains(number)) {
                    set.remove(number);
                    missing.add(number);
                }
            }
        }
        set.stream().sorted().forEach(n -> System.out.println("New Folder" + ((n == 1) ? "" : " (" + n + ")")));
    }
}
