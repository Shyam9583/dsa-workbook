package com.technotap.dsaworkbook.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Interval[] arr = new Interval[]{
                new Interval(1, 5),
                new Interval(3, 7),
                new Interval(4, 6),
                new Interval(6, 8),
                new Interval(10, 12),
                new Interval(12, 15)
        };
        System.out.println(merge(arr, arr.length));
    }

    private static ArrayList<Interval> merge(Interval[] arr, int n) {
        Arrays.sort(arr);
        ArrayList<Interval> result = new ArrayList<>();
        Interval selected = new Interval(arr[0]);
        for (int i = 1; i < n; i++) {
            if (selected.end >= arr[i].start) {
                if (selected.end < arr[i].end)
                    selected.end = arr[i].end;
            } else {
                result.add(selected);
                selected = new Interval(arr[i]);
            }
        }
        result.add(selected);
        return result;
    }

    private static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Interval(Interval o) {
            this.start = o.start;
            this.end = o.end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }
}
