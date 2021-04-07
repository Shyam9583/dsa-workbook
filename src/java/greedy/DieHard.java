package java.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class DieHard {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] HA;
        for (int t = 0; t < T; t++) {
            HA = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            System.out.println(survivalTime(HA[0], HA[1]));
        }
    }

    private static int survivalTime(int health, int armor) {
        HashMap<String, Integer> dp = new HashMap<>();
        return survive(health + 3, armor + 2, 0, dp);
    }

    private static int survive(int health, int armor, int step, HashMap<String, Integer> dp) {
        String key = health + "X" + armor;
        if (dp.containsKey(key)) return dp.get(key);
        if (health < 1 || armor < 1) return 0;
        if (step != 0) return survive(health + 3, armor + 2, 0, dp) + 1;
        dp.putIfAbsent(key, Math.max(
                survive(health - 5, armor - 10, 1, dp),
                survive(health - 20, armor + 5, 1, dp)
        ) + 1);
        return dp.get(key);
    }

}
