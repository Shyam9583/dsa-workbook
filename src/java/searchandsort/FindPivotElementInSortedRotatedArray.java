package java.searchandsort;

public class FindPivotElementInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 1, 2, 3};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(pivot(arr1, 0, arr1.length - 1, 0, arr1.length - 1));
        System.out.println(pivot(arr2, 0, arr2.length - 1, 0, arr2.length - 1));
    }

    private static int pivot(int[] arr, int low, int high, int lowerBound, int upperBound) {
        int mid = low + (high - low) / 2;
        if (mid == lowerBound) {
            if (mid == upperBound)
                return mid;
            else if (arr[mid] >= arr[mid + 1])
                return mid;
        } else if (mid == upperBound) {
            if (arr[mid] >= arr[mid - 1])
                return mid;
        } else {
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[high]) {
                return pivot(arr, mid, high, lowerBound, upperBound);
            } else if (arr[mid] < arr[high]) {
                return pivot(arr, low, mid, lowerBound, upperBound);
            }
        }
        return -1;
    }
}
