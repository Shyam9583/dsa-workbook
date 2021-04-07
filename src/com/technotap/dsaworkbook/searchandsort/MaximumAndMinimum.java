package com.technotap.dsaworkbook.searchandsort;

public class MaximumAndMinimum {

    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000, 55, 555, 680, 554};
        MaxMin result = maxMin(arr, 0, arr.length - 1);
        System.out.println("max = " + result.max + ", min = " + result.min);
        System.out.println(count);
    }

    private static MaxMin maxMin(int[] arr, int low, int high) {
        if (low == high)
            return new MaxMin(arr[low], arr[high]);
        else if (high - low == 1) {
            count++;
            return new MaxMin(Math.max(arr[low], arr[high]), Math.min(arr[low], arr[high]));
        } else {
            int mid = low + (high - low) / 2;
            MaxMin left = maxMin(arr, low, mid);
            MaxMin right = maxMin(arr, mid + 1, high);
            count++;
            return new MaxMin(Math.max(left.max, right.max), Math.min(left.min, right.min));
        }
    }

    private static class MaxMin {
        int max, min;

        MaxMin(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

}
