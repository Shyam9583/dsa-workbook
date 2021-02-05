package array;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "gesek";
        System.out.println(editDistance(s1, s2));
    }

    private static int editDistance(String s1, String s2) {
        if (s1.equals(s2))
            return 0;
        int ROW = s1.length(), COL = s2.length();
        int[][] operations = new int[ROW + 1][COL + 1];
        for (int i = 1; i <= ROW; i++) {
            operations[i][0] = i;
        }
        for (int i = 1; i <= COL; i++) {
            operations[0][i] = i;
        }
        for (int i = 1; i <= ROW; i++) {
            for (int j = 1; j <= COL; j++) {
                int min = Math.min(operations[i - 1][j - 1], Math.min(operations[i][j - 1], operations[i - 1][j]));
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    operations[i][j] = min;
                else
                    operations[i][j] = min + 1;
            }
        }

        return operations[ROW][COL];
    }
}
