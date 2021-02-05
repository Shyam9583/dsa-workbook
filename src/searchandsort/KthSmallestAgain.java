package searchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KthSmallestAgain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T, N, Q;
        Interval[] intervals;
        T = Integer.parseInt(reader.readLine().trim());
        for (int t = 0; t < T; t++) {
            int[] NQ = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            N = NQ[0];
            Q = NQ[1];
            intervals = new Interval[N];
            for (int n = 0; n < N; n++) {
                long[] it = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToLong(Long::parseLong).toArray();
                intervals[n] = new Interval(it[0], it[1]);
            }
            Arrays.sort(intervals, (Comparator.comparingLong(o -> o.start)));
            ArrayList<Interval> mergedIntervals = merge(intervals);
            for (int q = 0; q < Q; q++) {
                long k = Integer.parseInt(reader.readLine().trim());
                System.out.println(kthSmallest(mergedIntervals, k));
            }
        }
    }

    private static ArrayList<Interval> merge(Interval[] intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        Interval temp = intervals[0];
        for (Interval it : intervals) {
            if (it.start <= temp.end) {
                temp.end = Math.max(it.end, temp.end);
            } else {
                result.add(temp);
                temp = it;
            }
        }
        result.add(temp);
        return result;
    }

    private static long kthSmallest(ArrayList<Interval> intervals, long k) {
        for (Interval it : intervals) {
            long range = it.end - it.start + 1;
            if (k <= range) {
                return it.start + k - 1;
            } else
                k -= range;
        }
        return -1;
    }

    private static class Interval {
        long start, end;

        Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
