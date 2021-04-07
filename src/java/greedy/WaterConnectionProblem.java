package java.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class WaterConnectionProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] NP;
        int[] pipe;
        TreeMap<Integer, House> map = new TreeMap<>();
        for (int t = 0; t < T; t++) {
            map.clear();
            NP = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < NP[0]; i++) map.put(i + 1, new House(i + 1));
            for (int p = 0; p < NP[1]; p++) {
                pipe = Arrays.stream(reader.readLine().trim().split(" ")).limit(3).mapToInt(Integer::parseInt).toArray();
                connect(map, pipe[0], pipe[1], pipe[2]);
            }
            printPipes(map);
        }
    }

    private static void printPipes(TreeMap<Integer, House> map) {
        int count = 0;
        ArrayList<Result> results = new ArrayList<>();
        for (int house : map.keySet()) {
            House curr = map.get(house);
            if (curr.intake == 0 && curr.next != null) {
                int min = curr.outtake;
                while (curr.outtake != 0) {
                    if (min > curr.outtake)
                        min = curr.outtake;
                    curr = curr.next;
                }
                results.add(new Result(house, curr.id, min));
                count++;
            }
        }
        System.out.println(count);
        for (Result result : results) {
            System.out.println(result.start + " " + result.end + " " + result.diameter);
        }
    }

    private static void connect(TreeMap<Integer, House> map, int a, int b, int d) {
        House A = map.get(a);
        House B = map.get(b);
        A.outtake = d;
        B.intake = d;
        A.next = B;
    }

    private static class House {
        int id, intake = 0, outtake = 0;
        House next = null;

        House(int id) {
            this.id = id;
        }
    }

    private static class Result {

        int start, end, diameter;

        Result(int start, int end, int diameter) {
            this.start = start;
            this.end = end;
            this.diameter = diameter;
        }
    }
}
