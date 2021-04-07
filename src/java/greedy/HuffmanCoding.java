package java.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        String characters;
        int[] frequencies;
        for (int t = 0; t < T; t++) {
            characters = reader.readLine().trim();
            frequencies = Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            huffmanEncoding(characters, frequencies);
        }
    }

    private static void huffmanEncoding(String characters, int[] frequencies) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            minHeap.add(new Node(characters.charAt(i), frequencies[i]));
        }
        while (minHeap.size() >= 2) {
            Node left = minHeap.poll(), right = minHeap.poll();
            if (right != null) minHeap.add(new Node('$', left.frequency + right.frequency, left, right));
        }
        printNodes(minHeap.poll(), "");
        System.out.println();
    }

    private static void printNodes(Node root, String sequence) {
        if (root == null) return;
        printNodes(root.left, sequence + "0");
        printNodes(root.right, sequence + "1");
        if (root.value != '$')
            System.out.print(sequence + " ");
    }

    private static class Node implements Comparable<Node> {
        char value;
        int frequency;
        Node left, right;

        Node(char value, int frequency, Node left, Node right) {
            this.value = value;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        Node(char value, int frequency) {
            this(value, frequency, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", frequency=" + frequency +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return frequency - o.frequency;
        }
    }

}
