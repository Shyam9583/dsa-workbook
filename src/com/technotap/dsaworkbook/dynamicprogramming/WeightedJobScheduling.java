package com.technotap.dsaworkbook.dynamicprogramming;

import java.util.Arrays;

public class WeightedJobScheduling {
    public static void main(String[] args) {
        int[][] arr = {{3, 10, 20}, {1, 2, 50}, {6, 19, 100}, {2, 100, 200}};
        Job[] jobs = Arrays.stream(arr).map((item) -> new Job(item[0], item[1], item[2])).toArray(Job[]::new);
        System.out.println(maxProfit(jobs));
    }

    private static int maxProfit(Job[] jobs) {
        Arrays.sort(jobs);
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            int j = findLatestNonConflicting(jobs, i);
            int including = jobs[i].profit;
            if (j != -1) including += dp[j];
            dp[i] = Math.max(dp[i - 1], including);
        }
        return dp[jobs.length - 1];
    }

    private static int findLatestNonConflicting(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j].end <= jobs[i].start) return j;
        }
        return -1;
    }

    private static class Job implements Comparable<Job> {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }

        @Override
        public int compareTo(Job job) {
            if (end == job.end) return start - job.start;
            return end - job.end;
        }
    }
}
