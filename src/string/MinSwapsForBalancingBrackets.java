package string;

public class MinSwapsForBalancingBrackets {
    public static void main(String[] args) {
        String expression = "[[][]]";
        System.out.println(minSwaps(expression));
    }

    private static int minSwaps(String s) {
        int close = 0, open = 0, fault = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                close++;
                fault = close - open;
            } else {
                open++;
                if (fault > 0) {
                    ans += fault;
                    fault--;
                }
            }
        }
        return ans;
    }
}

