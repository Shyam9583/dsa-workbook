package java.string;

public class CountStringIn2DArray {
    public static void main(String[] args) {
        char[][] chars = {
                {'D', 'D', 'D', 'G', 'D', 'D'},
                {'B', 'B', 'D', 'E', 'B', 'S'},
                {'B', 'S', 'K', 'E', 'B', 'K'},
                {'D', 'D', 'D', 'D', 'D', 'E'},
                {'D', 'D', 'D', 'D', 'D', 'E'},
                {'D', 'D', 'D', 'D', 'D', 'G'}
        };
        String s = "GEEKS";

//        char[][] chars = {
//                {'B','B','M','B','B','B'},
//                {'C','B','A','B','B','B'},
//                {'I','B','G','B','B','B'},
//                {'G','B','I','B','B','B'},
//                {'A','B','C','B','B','B'},
//                {'M','C','I','G','A','M'}
//        };
//
//        String s = "MAGIC";


        System.out.println(countString(chars, s));
    }

    private static int countString(char[][] chars, String s) {
        int MAX_ROW = chars.length, MAX_COL = chars[0].length, STR_LEN = s.length();
        int count = 0;
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                count += find(chars, MAX_ROW, MAX_COL, s, i, j, 0, STR_LEN);
            }
        }
        return count;
    }

    private static int find(char[][] chars, int MAX_ROW, int MAX_COL, String s, int i, int j, int strIdx, int STR_LEN) {
        int found = 0;
        if (i >= 0 && i < MAX_ROW && j >= 0 && j < MAX_COL) {
            if (chars[i][j] == s.charAt(strIdx)) {
                char temp = chars[i][j];
                chars[i][j] = '\0';
                strIdx++;
                if (strIdx == STR_LEN) {
                    found = 1;
                } else {
                    found += find(chars, MAX_ROW, MAX_COL, s, i - 1, j, strIdx, STR_LEN);
                    found += find(chars, MAX_ROW, MAX_COL, s, i + 1, j, strIdx, STR_LEN);
                    found += find(chars, MAX_ROW, MAX_COL, s, i, j - 1, strIdx, STR_LEN);
                    found += find(chars, MAX_ROW, MAX_COL, s, i, j + 1, strIdx, STR_LEN);
                }
                chars[i][j] = temp;
            }
        }
        return found;
    }
}
