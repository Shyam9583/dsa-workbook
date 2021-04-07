package java.greedy;

import java.util.Arrays;

public class JobScheduling {

    public static void main(String[] args) {
        int[][] jobArray = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}};
        Job[] jobs = new Job[jobArray.length];
        for (int i = 0; i < jobArray.length; i++) jobs[i] = new Job(jobArray[i][0], jobArray[i][2], jobArray[i][1]);
        System.out.println(Arrays.toString(jobScheduling(jobs, jobs.length)));
    }

    private static int[] jobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o2.profit, o1.profit));
        boolean[] slots = new boolean[maxDeadline(jobs)];
        int nScheduled = 0, maxProfit = 0;
        for (Job job : jobs) {
            int i = job.deadline - 1;
            while (i >= 0 && slots[i]) i--;
            if (i != -1) {
                slots[i] = true;
                nScheduled++;
                maxProfit += job.profit;
            }
        }
        return new int[]{nScheduled, maxProfit};
    }

    private static int maxDeadline(Job[] jobs) {
        int max = Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (max < job.deadline)
                max = job.deadline;
        }
        return max;
    }

    private static class Job {
        int id, profit, deadline;

        Job(int id, int profit, int deadline) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
