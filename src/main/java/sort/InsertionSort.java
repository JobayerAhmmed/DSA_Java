package main.java.sort;

// O(N^2)
// For small size array
// Worst case - input reversed sorted array

public class InsertionSort {

    public static void main(String[] args) {
        int[] data = new int[]{2, 4, 3, 5, 6, 1};
        sort(data);
        for (int item : data) {
            System.out.print(item + " ");
        }
    }

    public static void sort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int item = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > item) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = item;
        }
    }
}
