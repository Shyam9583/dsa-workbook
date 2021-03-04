package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateDistributionProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int nPackets, nStudents;
        int[] packets;
        for (int t = 0; t < T; t++) {
            nPackets = Integer.parseInt(reader.readLine());
            packets = Arrays.stream(reader.readLine().trim().split(" ")).limit(nPackets).mapToInt(Integer::parseInt).toArray();
            nStudents = Integer.parseInt(reader.readLine());
            System.out.println(minimumDifference(packets, nPackets, nStudents));
        }
    }

    private static int minimumDifference(int[] packets, int nPackets, int nStudents) {
        Arrays.sort(packets);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nPackets - nStudents; i++) {
            min = Math.min(min, packets[i + nStudents - 1] - packets[i]);
        }
        return min;
    }
}
