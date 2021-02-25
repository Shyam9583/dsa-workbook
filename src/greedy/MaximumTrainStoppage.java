package greedy;

import java.util.Arrays;

public class MaximumTrainStoppage {

    public static void main(String[] args) {
        int[][] trains = {
                {1000, 1030, 1},
                {1010, 1030, 1},
                {1000, 1020, 2},
                {1030, 1230, 2},
                {1200, 1230, 3},
                {900, 1005, 1}
        };
        int nPlatforms = 3;
        System.out.println(maxStoppage(trains, trains.length, nPlatforms));
    }

    private static int maxStoppage(int[][] trainsArray, int nTrains, int nPlatforms) {
        Train[] trains = new Train[nTrains];
        Train[] platforms = new Train[nPlatforms];
        for (int i = 0; i < nTrains; i++)
            trains[i] = new Train(trainsArray[i][0], trainsArray[i][1], trainsArray[i][2]);
        Arrays.sort(trains);
        int count = 0;
        for (Train train : trains) {
            if (platforms[train.platform - 1] == null || platforms[train.platform - 1].departure < train.arrival) {
                platforms[train.platform - 1] = train;
                count++;
            }
        }
        return count;
    }

    private static class Train implements Comparable<Train> {
        int arrival, departure, platform;

        Train(int arrival, int departure, int platform) {
            this.arrival = arrival;
            this.departure = departure;
            this.platform = platform;
        }

        @Override
        public int compareTo(Train o) {
            if (departure < o.departure)
                return -1;
            if (departure > o.departure)
                return 1;
            return arrival >= o.arrival ? -1 : 1;
        }
    }

}
