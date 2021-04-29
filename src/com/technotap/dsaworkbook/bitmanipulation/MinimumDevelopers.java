package com.technotap.dsaworkbook.bitmanipulation;

import java.util.ArrayList;

public class MinimumDevelopers {
    private static ArrayList<Integer> result;

    public static void main(String[] args) {
        int[][] devs = {{0, 2}, {1, 3}, {2, 4}, {4}};
        int nSkills = 5;
        System.out.println(developers(devs, nSkills));
    }

    private static ArrayList<Integer> developers(int[][] devs, int nSkills) {
        result = null;
        int[] people = new int[devs.length];
        for (int i = 0; i < devs.length; i++) {
            int skills = 0;
            for (int skill : devs[i]) {
                skills |= (1 << skill);
            }
            people[i] = skills;
        }
        findTeam(people, 0, nSkills, new ArrayList<>(), 0);
        return result;
    }

    private static void findTeam(int[] people, int cp, int nSkills, ArrayList<Integer> curr, int mask) {
        if (cp == people.length) {
            if ((mask == (1 << nSkills) - 1) && (result == null || result.size() > curr.size())) {
                result = new ArrayList<>(curr);
            }
            return;
        }
        findTeam(people, cp + 1, nSkills, curr, mask);
        curr.add(cp);
        findTeam(people, cp + 1, nSkills, curr, mask | people[cp]);
        curr.remove(curr.size() - 1);
    }
}
