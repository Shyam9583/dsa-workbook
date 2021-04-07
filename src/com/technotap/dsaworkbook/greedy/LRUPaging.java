package com.technotap.dsaworkbook.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LRUPaging {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int n, capacity;
        int[] pages;
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(reader.readLine());
            pages = Arrays.stream(reader.readLine().trim().split(" ")).limit(n).mapToInt(Integer::parseInt).toArray();
            capacity = Integer.parseInt(reader.readLine());
            System.out.println(pageFaults(pages, n, capacity));
        }
    }

    private static int pageFaults(int[] pages, int n, int capacity) {
        Map<Integer, Boolean> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int current = 0, pageFault = 0;
        for (int page : pages) {
            if (!map.containsKey(page)) {
                if (current == capacity) {
                    int last = q.remove();
                    map.remove(last);
                    current--;
                }
                map.put(page, true);
                q.add(page);
                pageFault++;
                current++;
            } else {
                q.remove(page);
                q.add(page);
            }
        }
        return pageFault;
    }
}
