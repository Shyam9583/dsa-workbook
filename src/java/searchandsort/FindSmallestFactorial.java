package java.searchandsort;

public class FindSmallestFactorial {
    public static void main(String[] args) {
        int n = 28;
        System.out.println(search(n));
    }

    private static int search(int n) {
        if (n == 1)
            return 5;
        int low = 0, high = 5 * n;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (zeroesInFactorial(mid) == n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int zeroesInFactorial(int n) {
        int result = 0;
        while (n > 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
