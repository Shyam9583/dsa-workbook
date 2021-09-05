package com.technotap.dsaworkbook.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoadsAndLibraries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(reader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultiLine = reader.readLine().replace("\\s+$", "").trim().split(" ");
                int n = Integer.parseInt(firstMultiLine[0]);
                int m = Integer.parseInt(firstMultiLine[1]);
                int c_lib = Integer.parseInt(firstMultiLine[2]);
                int c_road = Integer.parseInt(firstMultiLine[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Arrays.stream(reader.readLine().replace("\\s+$", "").trim().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList())
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                long result = roadsAndLibraries(n, c_lib, c_road, cities);
                writer.write(String.valueOf(result));
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        reader.close();
        writer.close();
    }

    private static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (List<Integer> road : cities) {
            int first = road.get(0);
            int second = road.get(1);
            int parentFirst = find(parent, first - 1);
            int parentSecond = find(parent, second - 1);

            if (parentFirst != parentSecond) {
                union(parent, first - 1, second - 1);
            }
        }

        long result = 0;

        for (int p : parent) {
            if (p < 0) {
                int nCities = -p;
                result += Math.min((long) c_lib * nCities, c_lib + (long) c_road * (nCities - 1));
            }
        }

        return result;
    }

    private static void union(int[] parent, int a, int b) {
        int parentA = find(parent, a);
        int parentB = find(parent, b);

        if (parent[parentA] < parent[parentB]) {
            parent[parentA] += parent[parentB];
            parent[parentB] = parentA;
        } else {
            parent[parentB] += parent[parentA];
            parent[parentA] = parentB;
        }
    }

    private static int find(int[] parent, int x) {
        int root = x;
        while (parent[root] > 0) root = parent[root];
        while (x != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }
}
