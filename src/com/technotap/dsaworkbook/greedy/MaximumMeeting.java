package com.technotap.dsaworkbook.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeeting {

    public static void main(String[] args) {
        int[] s = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, f = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        System.out.println(Arrays.toString(maxMeetings(s, f, s.length)));
    }

    private static int[] maxMeetings(int[] s, int[] f, int n) {
        int[][] meetings = new int[n][3];
        for (int i = 0; i < n; i++) {
            meetings[i] = new int[]{i + 1, s[i], f[i]};
        }
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        int[] result = new int[n];
        result[0] = meetings[0][0];
        int selection = meetings[0][2], size = 1;
        for (int i = 1; i < n; i++) {
            if (selection < meetings[i][1]) {
                selection = meetings[i][2];
                result[size++] = meetings[i][0];
            }
        }
        return Arrays.copyOf(result, size);
    }
}
