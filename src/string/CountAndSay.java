package string;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        if (n == 1)
            return "1";
        else {
            String response = countAndSay(n - 1);
            StringBuilder result = new StringBuilder();
            int count = 0;
            char lastNumber = response.charAt(0);
            for (int i = 0; i < response.length(); i++) {
                if (response.charAt(i) == lastNumber) {
                    count++;
                } else {
                    result.append(count).append(response.charAt(i - 1));
                    count = 1;
                    lastNumber = response.charAt(i);
                }
            }
            result.append(count).append(lastNumber);
            return result.toString();
        }
    }
}
