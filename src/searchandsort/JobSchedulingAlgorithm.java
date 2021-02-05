package searchandsort;

import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingAlgorithm {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 50},
                {3, 5, 20},
                {6, 19, 100},
                {2, 100, 200}
        };
        Job[] jobs = new Job[arr.length];
        for (int i = 0; i < arr.length; i++) {
            jobs[i] = new Job(arr[i]);
        }
        System.out.println(maxProfit(jobs));
    }

    private static int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o.finish));
        int[] max = new int[jobs.length];
        max[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            int including = jobs[i].profit;
            int latest = binarySearch(jobs, i);
            if (latest != -1) {
                including += max[latest];
            }
            max[i] = Math.max(max[i - 1], including);
        }
        return max[jobs.length - 1];
    }

    /* latest non-conflicting job */
    private static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = jobs.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    low = mid + 1;
                else
                    return mid;
            } else
                high = mid - 1;
        }
        return -1;
    }

    private static class Job {
        int start, finish, profit;

        Job(int... inputs) {
            this.start = inputs[0];
            this.finish = inputs[1];
            this.profit = inputs[2];
        }
    }
}
