package java.heap;

import java.util.Arrays;

public class MinimumSumFormedFromDigits {
    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        System.out.println(solve(arr, arr.length));
    }

    private static String solve(int[] arr, int n) {
        Arrays.sort(arr);
        int carry = 0, i = n - 1, j = n - 2;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += arr[i];
                i = i - 2;
            }
            if (j >= 0) {
                sum += arr[j];
                j = j - 2;
            }
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        if (carry != 0) result.insert(0, carry);
        while (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
