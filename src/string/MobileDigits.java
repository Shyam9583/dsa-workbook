package string;

public class MobileDigits {
    public static void main(String[] args) {
        String text = "GEEKSFORGEEKS";
        String result = "4333355777733366677743333557777";
        String[] keys = {"2", "22", "222",
                "3", "33", "333",
                "4", "44", "444",
                "5", "55", "555",
                "6", "66", "666",
                "7", "77", "777", "7777",
                "8", "88", "888",
                "9", "99", "999", "9999"
        };
        System.out.println(mobileDigits(text, keys).equals(result));
    }

    private static String mobileDigits(String text, String[] keys) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                stringBuilder.append(0);
            else {
                int position = text.charAt(i) - 'A';
                stringBuilder.append(keys[position]);
            }
        }
        return stringBuilder.toString();
    }
}
