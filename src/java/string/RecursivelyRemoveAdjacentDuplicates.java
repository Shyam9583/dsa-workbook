package java.string;

public class RecursivelyRemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String string = "aabb";
        System.out.println(removeDuplicates(string));
    }

    private static String removeDuplicates(String string) {
        return removeIterative(string);
    }

    private static String removeRecursive(String string, String result) {
        if (string.isEmpty()) {
            return result;
        } else if (result.isEmpty()) {
            return removeRecursive(string.substring(1), result + string.charAt(0));
        } else {
            if (result.charAt(result.length() - 1) == string.charAt(0))
                return removeRecursive(string.substring(1), result);
            else
                return removeRecursive(string.substring(1), result + string.charAt(0));
        }
    }

    private static String removeIterative(String string) {
        StringBuilder result = new StringBuilder();
        char last = '\0';
        for (int i = 0; i < string.length(); i++) {
            if (last != string.charAt(i)) {
                last = string.charAt(i);
                result.append(last);
            }
        }
        return result.toString();
    }
}
