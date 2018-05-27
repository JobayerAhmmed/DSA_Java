package main.java.search;

// Worst case: log(n)
// Return index of target element of a sorted array

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = new int[] {20, 30, 40, 50, 80, 90, 100};
        int targetIndex = binarysearch(data, 40);
        System.out.println(targetIndex);
        targetIndex = binarysearch(data, 3, 6, 90);
        System.out.println(targetIndex);
    }

    public static int binarysearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int middle = low + (high - low)/2;
            if (data[middle] < target)
                low = middle + 1;
            else if (data[middle] > target)
                high = middle - 1;
            else
                return middle;
        }
        return -1;
    }

    public static int binarysearch(int[] data, int low, int high, int target) {
        while (low <= high) {
            int middle = low + (high - low)/2;
            if (data[middle] < target)
                low = middle + 1;
            else if (data[middle] > target)
                high = middle - 1;
            else
                return middle;
        }
        return -1;
    }
}
