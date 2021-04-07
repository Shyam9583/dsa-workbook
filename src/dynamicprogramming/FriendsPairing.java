package dynamicprogramming;

public class FriendsPairing {

    private static final long M = (long) (1e9 + 7);

    public static void main(String[] args) {
        int n = 100000;
        System.out.println(countFriendsPairing(n));
    }

    private static long countFriendsPairing(int n) {
        if (n < 3) return n;
        long last1 = 2, last2 = 1, curr = 0;
        for (int i = 2; i < n; i++) {
            curr = (last1 + i * last2) % M;
            last2 = last1;
            last1 = curr;
        }
        return curr;
    }
}
