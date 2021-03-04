package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CombinationSum {
    public static void main(String[] args) {
        Integer[] arr = {6, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9};
        int sum = 6;
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        ArrayList<ArrayList<Integer>> result = combinationSum(list, sum);
        result.forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        new TreeSet<>(arr);
        arr = new ArrayList<>(new TreeSet<>(arr));
        recursive(arr, result, new ArrayList<>(), sum, 0);
        return result;
    }

    private static void recursive(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int sum, int pos) {
        if (sum < 0 || pos >= arr.size()) return;
        if (sum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        int item = arr.get(pos);
        current.add(item);
        recursive(arr, result, current, sum - item, pos);
        current.remove(current.size() - 1);
        recursive(arr, result, current, sum, pos + 1);
    }
}
