package com.technotap.dsaworkbook.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountPageFaults {
    public static void main(String[] args) throws IOException {
//        int N = 9, C = 4;
//        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        BufferedReader reader = new BufferedReader(new FileReader("/tmp/fileInput.txt"));
        int N = Integer.parseInt(reader.readLine());
        int[] pages = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int C = Integer.parseInt(reader.readLine());
        System.out.println(pageFaults(N, C, pages));
    }

    private static int pageFaults(int N, int C, int[] pages) {
        Queue<Integer> history = new LinkedList<>();
        Set<Integer> isPresent = new HashSet<>();
        int nFaults = 0;

        for (int page : pages) {
            if (isPresent.contains(page)) {
                isPresent.remove(page);
                isPresent.add(page);
                continue;
            }
            nFaults++;
            if (history.size() == C) {
                int lru = history.remove();
                isPresent.remove(lru);
            }
            history.add(page);
            isPresent.add(page);
        }

        return nFaults;
    }
}
