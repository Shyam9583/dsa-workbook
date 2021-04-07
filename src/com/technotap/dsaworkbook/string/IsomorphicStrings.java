package com.technotap.dsaworkbook.string;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String A = "aab", B = "xyz";
        System.out.println(areIsomorphic(A, B));
    }

    private static boolean areIsomorphic(String A, String B) {
        int M = A.length(), N = B.length();
        if (M != N)
            return false;

        boolean[] seenInA = new boolean[256];
        boolean[] seenInB = new boolean[256];
        char[] mapping = new char[256];

        for (int i = 0; i < M; i++) {
            if (!seenInA[A.charAt(i)]) {
                seenInA[A.charAt(i)] = true;
                if (!seenInB[B.charAt(i)]) {
                    mapping[A.charAt(i)] = B.charAt(i);
                    seenInB[B.charAt(i)] = true;
                } else {
                    return false;
                }
            } else {
                if (mapping[A.charAt(i)] != B.charAt(i))
                    return false;
            }
        }

        return true;
    }
}
