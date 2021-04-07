package java.array;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println("Result : " + maxOnes(matrix, matrix.length, matrix[0].length));
    }

    private static int maxOnes(int[][] arr, int n, int m) {
        int i = 0, j = m - 1, maxIndex = 0;

        int first = firstOne(arr[0]);

        if (first != -1)
            j = first;

        while (j != -1 && i != n) {
            if (arr[i][j] == 0) {
                i++;
            }
            if (arr[i][j] == 1) {
                if (i != maxIndex)
                    maxIndex = i;
                j--;
            }
        }
        return maxIndex;
    }

    private static int firstOne(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1)
                return mid;
            else if (arr[mid] == 0)
                low = mid + 1;
            else
                high = mid;
        }

        return -1;
    }
}
