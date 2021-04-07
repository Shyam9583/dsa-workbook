package java.greedy;

import java.util.*;

public class SJFScheduling {

    public static void main(String[] args) {
        int[][] jobs = {
                {1, 0, 12},
                {2, 2, 4},
                {3, 3, 6},
                {4, 8, 5}
        };
        Arrays.stream(sjf(jobs, jobs.length)).forEach(System.out::println);
    }

    private static Result[] sjf(int[][] jobArray, int n) {
        int currentTime = 0;
        Result[] results = new Result[n];
        Map<Integer, ArrayList<Job>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Job job = new Job(jobArray[i][0], jobArray[i][1], jobArray[i][2]);
            map.putIfAbsent(job.arrivalTime, new ArrayList<>());
            map.get(job.arrivalTime).add(job);
            results[i] = new Result(job.id, job.burstTime);
        }
        PriorityQueue<Job> q = new PriorityQueue<>();
        while (map.get(currentTime) == null) currentTime++;
        q.addAll(map.get(currentTime));
        map.remove(currentTime);
        while (!q.isEmpty()) {
            if (map.containsKey(currentTime)) {
                q.addAll(map.get(currentTime));
            }
            Job job = q.poll();
            if (job != null) {
                job.burstTime--;
                if (job.burstTime > 0) {
                    q.add(job);
                } else {
                    results[job.id - 1].calculate(job.arrivalTime, currentTime);
                }
            }
            currentTime++;
        }
        return results;
    }

    private static class Job implements Comparable<Job> {
        int id, arrivalTime, burstTime;

        Job(int id, int arrivalTime, int burstTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", arrivalTime=" + arrivalTime +
                    ", burstTime=" + burstTime +
                    '}';
        }


        @Override
        public int compareTo(Job o) {
            return burstTime - o.burstTime;
        }
    }

    private static class Result {
        int id, turnaroundTime, waitingTime, burstTime;

        Result(int id, int burstTime) {
            this.id = id;
            this.burstTime = burstTime;
            this.turnaroundTime = this.waitingTime = 0;
        }

        void calculate(int arrivalTime, int finishTime) {
            turnaroundTime = finishTime - arrivalTime + 1;
            waitingTime = turnaroundTime - burstTime;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", turnaroundTime=" + turnaroundTime +
                    ", waitingTime=" + waitingTime +
                    ", burstTime=" + burstTime +
                    '}';
        }
    }
}
