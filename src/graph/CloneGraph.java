package graph;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        int N = 4;
        Node[] nodes = new Node[N];
        int[][] adjList = {
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3}
        };
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < N; i++) {
            for (int adj : adjList[i]) {
                nodes[i].neighbors.add(nodes[adj - 1]);
            }
        }
        print(nodes[0], N);
        Node newNode = cloneGraph(nodes[0]);
        print(newNode, N);
    }

    private static void print(Node node, int N) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (visited[curr.val - 1]) continue;
            System.out.println(curr.val);
            visited[curr.val - 1] = true;
            for (Node neighbor : curr.neighbors) {
                if (visited[neighbor.val - 1]) continue;
                q.add(neighbor);
            }
        }
    }

    private static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        cloneNode(node, map);
        boolean[] visited = new boolean[map.size()];
        cloneGraphRec(node, map, visited);
        return map.get(node);
    }

    private static void cloneGraphRec(Node node, Map<Node, Node> map, boolean[] visited) {
        if (node == null || visited[node.val - 1]) return;
        visited[node.val - 1] = true;
        for (Node neighbor : node.neighbors) {
            map.get(node).neighbors.add(map.get(neighbor));
            cloneGraphRec(neighbor, map, visited);
        }
    }

    private static void cloneNode(Node node, Map<Node, Node> map) {
        if (node == null || map.containsKey(node)) return;
        map.put(node, new Node(node.val));
        for (Node neighbor : node.neighbors) {
            cloneNode(neighbor, map);
        }
    }

    private static class Node {
        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
