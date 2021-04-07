package java.greedy;

public class SurviveOnTheIsland {
    public static void main(String[] args) {
        System.out.println(daysToBuyFood(10, 16, 2));
    }

    private static int daysToBuyFood(int S, int N, int M) {
        if (((6 * N < 7 * M) && S > 6) || M > N)
            return 0;
        int days = (S * M) / N;
        return (S * M) % N != 0 ? days + 1 : days;
    }
}
