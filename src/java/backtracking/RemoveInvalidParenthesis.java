package java.backtracking;

import java.util.*;

public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
        String expression = "(a)())()";
        System.out.println(removeBFS(expression));
    }

    private static List<String> removeBFS(String s) {
        if (s.isEmpty()) return emptyList();

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        boolean level = false;
        String temp;

        q.add(s);
        visited.add(s);

        while (!q.isEmpty()) {
            String str = q.remove();
            if (isBalanced(str)) {
                result.add(str);
                level = true;
            }
            if (level) continue;
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i))) continue;
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(temp)) {
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }

        return result;
    }

    private static boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }

    private static List<String> emptyList() {
        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }

    private static boolean isBalanced(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') counter++;
            else if (s.charAt(i) == ')') {
                if (counter == 0)
                    return false;
                counter--;
            }
        }
        return counter == 0;
    }

    private static int countWrongParenthesis(String s) {
        int total = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                total++;
            else if (s.charAt(i) == ')') {
                if (total > 0) total--;
                else temp++;
            }
        }
        return total + temp;
    }

    private static void removeUtil(String expression, HashSet<String> result, int index, int resultLen) {
        if (expression.length() == resultLen && isBalanced(expression)) {
            result.add(expression);
        } else if (expression.length() > resultLen) {
            if (index >= expression.length()) return;
            removeUtil(expression.substring(0, index) + expression.substring(index + 1), result, index, resultLen);
            removeUtil(expression, result, index + 1, resultLen);
        }
    }

    private static List<String> remove(String s) {
        int resultLen = s.length() - countWrongParenthesis(s);
        HashSet<String> result = new HashSet<>();
        removeUtil(s, result, 0, resultLen);
        if (result.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        return new ArrayList<>(result);
    }
}
