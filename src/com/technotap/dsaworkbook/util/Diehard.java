package com.technotap.dsaworkbook.util;

import java.util.HashMap;
import java.util.Map;

public class Diehard {
    public static void main(String[] args) {
        int health = 20, armor = 8;
        System.out.println(diehard(health, armor));
    }

    private static int diehard(int health, int armor) {
        return diehardUtil(health + 3, armor + 2, false, new HashMap<>());
    }

    private static int diehardUtil(int health, int armor, boolean notInAir, Map<String, Integer> dp) {
        if (health < 1 || armor < 1) return 0;

        String key = health + "X" + armor;
        if (dp.containsKey(key)) return dp.get(key);

        if (notInAir) return diehardUtil(health + 3, armor + 2, false, dp) + 1;

        dp.putIfAbsent(key, Math.max(
                diehardUtil(health - 5, armor - 10, true, dp),
                diehardUtil(health - 20, armor + 5, true, dp)) + 1);

        return dp.get(key);
    }
}
