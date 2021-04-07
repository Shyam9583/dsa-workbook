package com.technotap.dsaworkbook.binarytree;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Swaps_Needed_To_Convert_A_BinaryTree_To_A_BST {
    public static void main(String[] args) {
        int[] bt = {5, 6, 7, 8, 9, 10, 11};
        System.out.println(minSwapsNeeded(bt, bt.length));
    }

    private static void inorder(int[] tree, int index, Entry[] result, int[] ptr) {
        if (index >= tree.length) return;
        inorder(tree, 2 * index + 1, result, ptr);
        result[ptr[0]] = new Entry(tree[index], ptr[0]++);
        inorder(tree, 2 * index + 2, result, ptr);
    }

    private static int minSwapsNeeded(int[] tree, int n) {
        Entry[] inorder = new Entry[n];
        inorder(tree, 0, inorder, new int[]{0});
        Arrays.sort(inorder, Comparator.comparingInt(o -> o.value));
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int j = inorder[i].index;
            int c = 0;
            while (!visited[j] && j != i) {
                visited[j] = true;
                j = inorder[j].index;
                c++;
            }
            result += c;
        }
        return result;
    }

    private static class Entry {
        int value, index;

        Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
