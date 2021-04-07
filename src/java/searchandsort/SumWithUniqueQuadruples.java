package java.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SumWithUniqueQuadruples {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int K = 23;
        efficientQuadruples(arr, K).forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> quadruples(int[] arr, int k) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n < 4)
            return result;
        Arrays.sort(arr);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int oldLeft = left, oldRight = right;
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == k) {
                        result.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right])));
                        while (left < right && arr[left] == arr[oldLeft]) left++;
                        while (left < right && arr[right] == arr[oldRight]) right--;
                    }
                    if (sum < k)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> efficientQuadruples(int[] arr, int k) {
        int n = arr.length, m = (n * (n - 1) / 2), index = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n < 4)
            return result;

        Entry[] aux = new Entry[m];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                aux[index++] = new Entry(arr[i], arr[j]);
            }
        }

        Arrays.sort(aux, Comparator.comparingInt(o -> o.sum));

        int left = 0, right = m - 1;

        while (left < right) {
            int sum = aux[left].sum + aux[right].sum;
            int product = aux[left].product * aux[right].product;
            if (sum == k && noCommon(aux[left], aux[right])) {
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(aux[left].a, aux[left].b, aux[right].a, aux[right].b));
                temp.sort(Integer::compareTo);
                map.putIfAbsent(product, temp);
                left++;
                right--;
            }
            if (sum < k)
                left++;
            else
                right--;
        }

        for (int key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private static boolean noCommon(Entry A, Entry B) {
        return A.a != B.a && A.a != B.b && A.b != B.a && A.b != B.b;
    }

    private static class Entry {
        int product, sum, a, b;

        Entry(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
            this.product = a * b;
        }
    }
}
