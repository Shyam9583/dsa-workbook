package searchandsort;

import java.util.ArrayList;

public class FindValueEqualToIndex {
    public static void main(String[] args) {
        int[] numbers = {15, 2, 45, 12, 7};
        System.out.println(find(numbers));
    }

    private static ArrayList<Integer> find(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr[i])
                result.add(arr[i]);
        }
        return result;
    }
}
