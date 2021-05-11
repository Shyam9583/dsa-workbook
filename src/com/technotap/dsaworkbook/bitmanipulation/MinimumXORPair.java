package com.technotap.dsaworkbook.bitmanipulation;

public class MinimumXORPair {
    public static void main(String[] args) {
        int[] arr = {9, 5, 3};
        System.out.println(minXORPair(arr.length, arr));
    }

    private static int minXORPair(int N, int[] arr) {
        int min = Integer.MAX_VALUE;
        Node root = new Node();
        insert(root, arr[0]);
        for (int i = 1; i < N; i++) {
            min = Math.min(min, minXOR(root, arr[i]));
            insert(root, arr[i]);
        }
        return min;
    }

    private static void insert(Node root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (root.children[bit] == null) {
                root.children[bit] = new Node();
            }
            root = root.children[bit];
        }
        root.value = num;
    }

    private static int minXOR(Node root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (root.children[bit] != null) {
                root = root.children[bit];
            } else if (root.children[1 - bit] != null) {
                root = root.children[1 - bit];
            }
        }
        return num ^ root.value;
    }

    private static class Node {
        int value = 0;
        Node[] children = new Node[2];
    }
}
