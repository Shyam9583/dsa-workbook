package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinAndMaxAmountForCandy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] NK, prices;
        for (int t = 0; t < T; t++) {
            NK = Arrays.stream(reader.readLine().trim().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray();
            prices = Arrays.stream(reader.readLine().trim().split(" ")).limit(NK[0]).mapToInt(Integer::parseInt).toArray();
            amountRequired(prices, NK[0], NK[1]);
        }
    }

    private static void amountRequired(int[] prices, int n, int k) {
        Arrays.sort(prices);
        int min = 0, max = 0;
        for (int i = 0, remaining = n; i < n && remaining > 0; i++, remaining -= (k + 1)) {
            min += prices[i];
            max += prices[n - i - 1];
        }
        System.out.println(min + " " + max);
    }

}
