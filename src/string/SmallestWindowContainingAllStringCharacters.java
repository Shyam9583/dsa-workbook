package string;

public class SmallestWindowContainingAllStringCharacters {

    public static void main(String[] args) {
        String s = "GEEKSGEEKSFOR";
        System.out.println(minWindowSize(s, s.length()));
    }

    private static int minWindowSize(String s, int N) {

        // edge Cases to return
        if (N < 2) {
            return 1;
        } else if (N == 2) {
            return s.charAt(0) == s.charAt(1) ? 1 : 2;
        }

        // needed data
        boolean[] visited = new boolean[256];
        int[] count = new int[256];
        int minSize = N, distinctCount = 0, currentCount = 0, start = 0, end = 0, currentSize;

        // find number of distinct characters in the string
        for (int i = 0; i < N; i++) {
            if (!visited[s.charAt(i)])
                distinctCount++;
            visited[s.charAt(i)] = true;
        }

        // find the minimum window size using sliding window technique
        while (end < N) {
            count[s.charAt(end)]++;
            if (count[s.charAt(end)] == 1) {
                currentCount++;
            }

            // if we have found all distinct elements up to now, try to decrease the size of the sliding window
            if (currentCount == distinctCount) {
                while (count[s.charAt(start)] > 1) {
                    if (count[s.charAt(start)] > 1)
                        count[s.charAt(start)]--;
                    start++;
                }
                currentSize = end - start + 1;
                if (currentSize < minSize) {
                    minSize = currentSize;
                }
            }
            end++;
        }

        return minSize;
    }
}
