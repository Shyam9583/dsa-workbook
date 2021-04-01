package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlight {
    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, K = 0;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice(n, flights, src, dst, K));
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<Map<Integer, Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashMap<>());
        for (int[] flight : flights) adj.get(flight[0]).put(flight[1], flight[2]);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.remove();
            if (curr.port == dst) return curr.cost;
            if (curr.stops > K) continue;
            Map<Integer, Integer> neighbors = adj.get(curr.port);
            for (int neighbor : neighbors.keySet()) {
                pq.add(new Node(neighbor,
                        curr.cost + neighbors.get(neighbor),
                        curr.stops + 1
                ));
            }
        }
        return -1;
    }

    private static class Node implements Comparable<Node> {
        int port, cost, stops;

        Node(int port, int cost, int stops) {
            this.port = port;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Node node) {
            if (cost == node.cost) return this.port - node.port;
            return cost - node.cost;
        }
    }
}
