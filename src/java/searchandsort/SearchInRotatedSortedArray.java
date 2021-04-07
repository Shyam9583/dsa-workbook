package java.searchandsort;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int key = 3;
        System.out.println(find(arr, key));
    }

    private static int find(int[] arr, int target) {
        int p = largest(arr, 0, arr.length - 1);
        if (p == -1) {
            // the java.dsaworkbook.array is not rotated
            return search(arr, target, 0, arr.length - 1);
        } else {
            int first = search(arr, target, 0, p);
            int second = search(arr, target, p + 1, arr.length - 1);
            if (first != -1)
                return first;
            else
                return second;
        }
    }

    // find the partition point
    private static int largest(int[] arr, int low, int high) {
        // this part is different to binary search
        if (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1])
                return mid;
            else {
                // find in sub arrays
                int first = largest(arr, low, mid);
                int second = largest(arr, mid + 1, high);
                if (first != -1)
                    return first;
                else
                    return second;
            }
        }
        return -1;
    }

    // find the key
    private static int search(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
