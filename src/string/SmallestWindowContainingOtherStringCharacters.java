package string;

public class SmallestWindowContainingOtherStringCharacters {
    public static void main(String[] args) {
        String first = "zoomlazapzo";
        String second = "oza";
        System.out.println(smallestWindow(first, second));
    }

    // similar to single string case but, distinct is found from second string
    private static String smallestWindow(String first, String second) {
        int M = first.length(), N = second.length();
        int[] firstCount = new int[256];
        boolean[] secondVisited = new boolean[256];
        int minSize = Integer.MAX_VALUE, currentWindowSize;
        int distinctCount = 0, currentCount = 0;
        int start = 0, end = 0, startIndex = 0;

        for (int i = 0; i < N; i++) {
            if (!secondVisited[second.charAt(i)])
                distinctCount++;
            secondVisited[second.charAt(i)] = true;
        }

        while (end < M) {
            firstCount[first.charAt(end)]++;
            // current count is increased if first count == 1 and character is present in second string
            if (firstCount[first.charAt(end)] == 1 && secondVisited[first.charAt(end)]) {
                currentCount++;
            }
            if (currentCount == distinctCount) {
                // reduce window size if start character is redundant or character not present in second string (so we skip it)
                while (firstCount[first.charAt(start)] > 1 || !secondVisited[first.charAt(start)]) {
                    // skip the not present character
                    if (!secondVisited[first.charAt(start)]) {
                        start++;
                    }
                    // redundant character which is also present in second string
                    else if (firstCount[first.charAt(start)] > 1 && secondVisited[first.charAt(start)]) {
                        firstCount[first.charAt(start)]--;
                        start++;
                    }
                }
                currentWindowSize = end - start + 1;
                if (currentWindowSize < minSize) {
                    minSize = currentWindowSize;
                    startIndex = start;
                }
            }
            end++;
        }

        if (minSize == Integer.MAX_VALUE)
            return "-1";

        return first.substring(startIndex, startIndex + minSize);
    }
}
