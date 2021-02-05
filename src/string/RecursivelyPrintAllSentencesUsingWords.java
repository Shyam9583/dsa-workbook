package string;

public class RecursivelyPrintAllSentencesUsingWords {

    public static void main(String[] args) {
        String[][] words = {
                {"you", "we"},
                {"have", "are"},
                {"sleep", "eat", "drink"}
        };
        print(words);
    }

    private static void print(String[][] words) {
        printInternal(words, "", 0, words.length);
    }

    private static void printInternal(String[][] words, String result, int i, int SIZE) {
        if (i == SIZE)
            System.out.println(result);
        else {
            for (int k = 0; k < words[i].length; k++) {
                printInternal(words, result + " " + words[i][k], i + 1, SIZE);
            }
        }
    }
}
