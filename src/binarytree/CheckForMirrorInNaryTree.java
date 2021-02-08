package binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckForMirrorInNaryTree {

    private static class Tree {
        int nNodes;
        ArrayList<LinkedList<Integer>> adj;
        Tree(int nNodes) {
            this.nNodes = nNodes;
            adj = new ArrayList<>();
            adj.add(null);
            for(int i = 0; i < nNodes; i++) {
                adj.add(new LinkedList<>());
            }
        }
        void addEdge(int to, int from) {
            adj.get(from).add(to);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> fq = new LinkedList<>(), sq = new LinkedList<>();
        int T = Integer.parseInt(reader.readLine());
        for(int t = 0; t < T; t++) {
            int[] NE = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            int[] firstTreeNodes = Arrays.stream(reader.readLine().trim().split(" ")).limit(2L * NE[1]).mapToInt(Integer::parseInt).toArray();
            int[] secondTreeNodes = Arrays.stream(reader.readLine().trim().split(" ")).limit(2L * NE[1]).mapToInt(Integer::parseInt).toArray();
            Tree first = new Tree(NE[0]);
            Tree second = new Tree(NE[0]);
            for(int i = 0; i < 2L * NE[1]; i = i + 2) {
                first.addEdge(firstTreeNodes[i], firstTreeNodes[i + 1]);
                second.addEdge(secondTreeNodes[i], secondTreeNodes[i + 1]);
            }
            System.out.println(isMirror(first, second));
        }
    }

    private static int isMirror(Tree first, Tree second) {
        // TODO: Handle this function
        return 0;
    }

}
