package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    private static final  int INFINITY = 1 << 24;

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,-2},{0,3,-1},{0,4,-6},{0,6,2},{1,0,-2},{1,2,4},{1,4,-7},{1,6,10},{2,0,-8},{2,1,10},{2,6,-8},{3,1,-1},{3,4,4},{4,1,-11},{4,2,-10},{4,3,-4},{5,0,1},{5,2,8},{5,3,-3},{5,4,3},{5,6,6},{6,0,9},{6,1,1},{6,3,-11}};
        System.out.println(isNegativeWeightCycle(edges.length, edges));
    }

    private static int isNegativeWeightCycle(int n, int[][] edges) {
        int[] distance = new int[n];
        Arrays.fill(distance, INFINITY);
        distance[0] = 0;
        int nChanges = 0;
        for(int i = 0; i < n; i++) {
            nChanges = 0;
            for(int[] edge: edges) {
                if((distance[edge[0]] + edge[2]) < distance[edge[1]]) {
                    nChanges++;
                    distance[edge[1]] = distance[edge[0]] + edge[2];
                }
            }
        }
        return nChanges > 0 ? 1 : 0;
    }
}
