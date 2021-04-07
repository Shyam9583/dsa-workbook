package java.searchandsort;

public class FindInDiffArray {
    public static void main(String[] args) {
        int[] arr = {20, 40, 50, 70, 70, 60};
        int k = 20;
        int key = 50;
        System.out.println(find(arr, k, key));
    }

    private static int find(int[] arr, int k, int key) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == key)
                return i;
            else {
                i += Math.max(1, Math.abs(arr[i] - key) / k);
            }
        }
        return -1;
    }
}
